package br.com.gda.payService.payCustomer.model.action;

import java.sql.Connection;

import br.com.gda.business.phone.info.PhoneInfo;
import br.com.gda.business.phone.model.decisionTree.RootPhoneSelect;
import br.com.gda.info.InfoWritterFactory;
import br.com.gda.model.action.commom.ActionVisitorTemplateMerge;
import br.com.gda.model.decisionTree.DeciTree;
import br.com.gda.payService.payCustomer.info.PayCusInfo;
import br.com.gda.payService.payCustomer.info.PayCusMerger;

final class VisiPayCusMergePhone extends ActionVisitorTemplateMerge<PayCusInfo, PhoneInfo> {
	
	public VisiPayCusMergePhone(Connection conn, String schemaName) {
		super(conn, schemaName, PhoneInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<PhoneInfo>> getTreeClassHook() {
		return RootPhoneSelect.class;
	}
	
	
	
	@Override protected Class<? extends InfoWritterFactory<PayCusInfo>> getMergerClassHook() {
		return PayCusMerger.class;
	}
}
