package cn.gaoyuexiang.service.sale;

import cn.gaoyuexiang.model.PaymentItem;
import cn.gaoyuexiang.model.PaymentResult;

import java.util.List;

public interface SaleStrategy {
	PaymentResult calculate(List<PaymentItem> items);
}
