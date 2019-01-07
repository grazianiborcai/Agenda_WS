package br.com.gda.payService.payCustomer.model.action;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

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
	
	
	
	@Override protected List<PhoneInfo> toActionClassHook(List<PayCusInfo> recordInfos) {
		List<PhoneInfo> results = new ArrayList<>();
		
		for (PayCusInfo eachRecord : recordInfos) {
			PhoneInfo address = new PhoneInfo();
			address.codOwner = eachRecord.codOwner;
			address.codPayCustomer = eachRecord.codPayCustomer;
			results.add(address);
		}		
		
		return results;
	}
}
