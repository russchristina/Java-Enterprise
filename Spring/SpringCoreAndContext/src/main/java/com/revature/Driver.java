package com.revature;

import com.revature.service.PolkamanService;

public class Driver {

	public static void main(String...args) {
		PolkamanService polkamanService = new PolkamanService();
		System.out.println(polkamanService.findAll());
	}
}
