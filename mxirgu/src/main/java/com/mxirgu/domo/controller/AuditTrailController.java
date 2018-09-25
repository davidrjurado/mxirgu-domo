package com.mxirgu.domo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mxirgu.domo.bean.AuditTrailEntity;
import com.mxirgu.domo.service.AuditTrailService;

@Controller
@Scope("request")
public class AuditTrailController {

	private static final Logger logger = LoggerFactory.getLogger(AuditTrailController.class);

	@Autowired
	private AuditTrailService auditTrailService;
		
	@RequestMapping(value = "/listAuditTrail/{entity}", method = RequestMethod.GET)
	public String auditTrailList(@PathVariable int entity, Model model) {
		model.addAttribute("listAuditTrail", this.auditTrailService.listAuditTrailByEntity(AuditTrailEntity.USER));
		return "auditTrail/listAuditTrail";
	}

	

}
