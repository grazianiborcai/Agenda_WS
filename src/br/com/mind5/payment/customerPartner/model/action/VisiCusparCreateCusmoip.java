package br.com.mind5.payment.customerPartner.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.action.ActionVisitorTemplateActionV1;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.payment.customerPartner.info.CusparInfo;
import br.com.mind5.payment.customerPartner.info.CusparMerger;
import br.com.mind5.paymentPartner.partnerMoip.customerMoip.info.CusmoipInfo;
import br.com.mind5.paymentPartner.partnerMoip.customerMoip.model.decisionTree.RootCusmoipCreate;


final class VisiCusparCreateCusmoip extends ActionVisitorTemplateActionV1<CusparInfo, CusmoipInfo> {
	
	public VisiCusparCreateCusmoip(Connection conn, String schemaName) {
		super(conn, schemaName, CusparInfo.class, CusmoipInfo.class);
	}
	
	
	
	@Override protected ActionStdV1<CusmoipInfo> getActionHook(DeciTreeOption<CusmoipInfo> option) {
		return new RootCusmoipCreate(option).toAction();
	}
	
	
	
	@Override protected List<CusparInfo> toBaseClassHook(List<CusparInfo> baseInfos, List<CusmoipInfo> results) {
		return CusparMerger.mergeWithCusmoip(baseInfos, results);
	}
}
