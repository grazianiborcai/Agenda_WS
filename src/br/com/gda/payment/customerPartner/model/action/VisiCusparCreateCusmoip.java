package br.com.gda.payment.customerPartner.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.gda.model.action.ActionStd;
import br.com.gda.model.action.ActionVisitorTemplateAction;
import br.com.gda.model.decisionTree.DeciTreeOption;
import br.com.gda.payment.customerMoip.info.CusmoipInfo;
import br.com.gda.payment.customerMoip.model.decisionTree.RootCusmoipCreate;
import br.com.gda.payment.customerPartner.info.CusparInfo;


final class VisiCusparCreateCusmoip extends ActionVisitorTemplateAction<CusparInfo, CusmoipInfo> {
	
	public VisiCusparCreateCusmoip(Connection conn, String schemaName) {
		super(conn, schemaName, CusparInfo.class, CusmoipInfo.class);
	}
	
	
	
	@Override protected ActionStd<CusmoipInfo> getActionHook(DeciTreeOption<CusmoipInfo> option) {
		return new RootCusmoipCreate(option).toAction();
	}
	
	
	
	@Override protected List<CusparInfo> toBaseClassHook(List<CusparInfo> baseInfos, List<CusmoipInfo> results) {
		return baseInfos;
	}}
