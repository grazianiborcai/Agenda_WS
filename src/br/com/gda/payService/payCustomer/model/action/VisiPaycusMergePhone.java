package br.com.gda.payService.payCustomer.model.action;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.phone.info.PhoneInfo;
import br.com.gda.business.phone.model.decisionTree.RootPhoneSelect;
import br.com.gda.info.InfoWritterFactory;
import br.com.gda.model.action.ActionVisitorTemplateMerge;
import br.com.gda.model.decisionTree.DeciTree;
import br.com.gda.payService.payCustomer.info.PaycusInfo;
import br.com.gda.payService.payCustomer.info.PaycusMerger;

final class VisiPaycusMergePhone extends ActionVisitorTemplateMerge<PaycusInfo, PhoneInfo> {
	
	public VisiPaycusMergePhone(Connection conn, String schemaName) {
		super(conn, schemaName, PhoneInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<PhoneInfo>> getTreeClassHook() {
		return RootPhoneSelect.class;
	}
	
	
	
	@Override protected Class<? extends InfoWritterFactory<PaycusInfo>> getMergerClassHook() {
		return PaycusMerger.class;
	}
	
	
	
	@Override protected List<PhoneInfo> toActionClassHook(List<PaycusInfo> recordInfos) {
		List<PhoneInfo> results = new ArrayList<>();
		
		for (PaycusInfo eachRecord : recordInfos) {
			PhoneInfo address = new PhoneInfo();
			address.codOwner = eachRecord.codOwner;
			address.codPayCustomer = eachRecord.codPayCustomer;
			results.add(address);
		}		
		
		return results;
	}
}
