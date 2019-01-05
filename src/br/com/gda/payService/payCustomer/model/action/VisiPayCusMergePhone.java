package br.com.gda.payService.payCustomer.model.action;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.phone.info.PhoneInfo;
import br.com.gda.business.phone.model.decisionTree.RootPhoneSelect;
import br.com.gda.info.InfoWritterFactory;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.action.ActionVisitorTemplateAction;
import br.com.gda.model.decisionTree.DeciTreeOption;
import br.com.gda.payService.payCustomer.info.PayCusInfo;
import br.com.gda.payService.payCustomer.info.PayCusMerger;

final class VisiPayCusMergePhone extends ActionVisitorTemplateAction<PayCusInfo, PhoneInfo> {
	public VisiPayCusMergePhone(Connection conn, String schemaName) {
		super(conn, schemaName, PayCusInfo.class, PhoneInfo.class);
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
	
	
	
	@Override protected ActionStd<PhoneInfo> getActionHook(DeciTreeOption<PhoneInfo> option) {
		return new RootPhoneSelect(option).toAction();
	}
	
	
	
	@Override protected List<PayCusInfo> toBaseClassHook(List<PayCusInfo> baseInfos, List<PhoneInfo> results) {
		InfoWritterFactory<PayCusInfo> merger = new PayCusMerger();
		return merger.merge(results, baseInfos);
	}
}
