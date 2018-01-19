package org.joker.tv.controller.web;

import java.net.URI;

import org.joker.tv.common.Constants;
import org.joker.tv.model.front.web.ActivationResult;
import org.joker.tv.model.front.web.DeviceDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@Controller
public class ActivationController {

	@Autowired
	private RestTemplate restTemplate;

	@GetMapping("/activation")
	public String activation(Model model) {
		return "modules/activation/form";
	}

	@PostMapping("/activation")
	@ResponseBody
	public ActivationResult activateProduct(DeviceDto device, Model model) {
		UriComponentsBuilder uriBuilder = UriComponentsBuilder.fromHttpUrl(Constants._7STAR_ACTIVATION_URL).queryParam("login", device.getLogin())
				.queryParam("uid", device.getUid()).queryParam("serial", device.getSerial()).queryParam("model", device.getModel());
		URI url = uriBuilder.build().encode().toUri();
		return restTemplate.getForEntity(url, ActivationResult.class).getBody();
	}

	@GetMapping("/iks")
	public String iks(Model model) {
		return "modules/iks/form";
	}

	@PostMapping("/iks")
	@ResponseBody
	public ActivationResult iks(DeviceDto device, Model model) {
		UriComponentsBuilder uriBuilder = UriComponentsBuilder.fromHttpUrl(Constants._7STAR_ACTIVATION_URL).queryParam("ac", device.getLogin())
				.queryParam("ma", device.getUid()).queryParam("sn", device.getSerial());
		URI url = uriBuilder.build().encode().toUri();
		return restTemplate.getForEntity(url, ActivationResult.class).getBody();
	}

}
