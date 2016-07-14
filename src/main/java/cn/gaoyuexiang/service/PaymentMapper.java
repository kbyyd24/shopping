package cn.gaoyuexiang.service;

import cn.gaoyuexiang.exception.NoSuchItemException;
import cn.gaoyuexiang.model.Item;
import cn.gaoyuexiang.model.OnSaleInfo;
import cn.gaoyuexiang.model.PaymentItem;
import cn.gaoyuexiang.model.PaymentRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PaymentMapper {
	private ItemService itemService;
	private OnSaleService onSaleService;

	@Autowired
	public PaymentMapper(ItemService itemService, OnSaleService onSaleService) {
		this.itemService = itemService;
		this.onSaleService = onSaleService;
	}

	List<PaymentItem> map(PaymentRequest paymentRequest) {
		List<OnSaleInfo> onSaleInfos = onSaleService.getSaleInfos();
		List<Item> allItems = itemService.getItems();

		HashMap<String, PaymentItem> paymentItemMap = new HashMap<>();

		paymentRequest.getItems()
						.stream()
						.map(item -> {
							PaymentItem paymentItem = parsePayment(item, allItems);
							OnSaleInfo saleInfo = getSaleByBarcode(onSaleInfos, paymentItem.getItem());
							paymentItem.setSaleInfo(saleInfo);
							String barcode = paymentItem.getItem().getBarcode();
							if (paymentItemMap.containsKey(barcode)) {
								paymentItem.setAmount(paymentItemMap.get(barcode).getAmount() + paymentItem.getAmount());
								paymentItemMap.put(barcode,paymentItem);
							} else paymentItemMap.put(barcode, paymentItem);
							return paymentItem;
						})
						.collect(Collectors.toList());

		return paymentItemMap.values()
						.stream()
						.map(item -> item)
						.collect(Collectors.toList());

	}

	private OnSaleInfo getSaleByBarcode(List<OnSaleInfo> onSaleInfoes, Item item) {
		Optional<OnSaleInfo> first = onSaleInfoes
						.stream()
						.filter(t -> t.getBarcodes().contains(item.getBarcode()))
						.findFirst();
		return first.orElse(null);
	}

	private PaymentItem parsePayment(String paymentItem, List<Item> items) {
		String[] ps = paymentItem.trim().split("-");
		String barcode = ps[0];
		Optional<Item> matchedItem = items
						.stream()
						.filter(item -> item.getBarcode().equalsIgnoreCase(barcode))
						.findFirst();
		// no item
		if (!matchedItem.isPresent()) {
			throw new NoSuchItemException(String.format("No such item with barcode %s", barcode));
		}
		int amount = ps.length > 1 ? Integer.parseInt(ps[1]) : 1;
		return new PaymentItem(matchedItem.get(), amount);
	}
}
