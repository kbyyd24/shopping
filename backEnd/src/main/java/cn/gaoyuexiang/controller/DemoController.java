package cn.gaoyuexiang.controller;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by melo on 16-7-2.
 * demo controller
 */
@RestController
@EnableAutoConfiguration
public class DemoController {
	@RequestMapping(name = "/", method = RequestMethod.GET)
	public String homeDemo() {
		return "hello boot";
	}
}
