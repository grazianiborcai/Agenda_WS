package br.com.gda.payService.payCustomer.model.action;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.address.info.AddressInfo;
import br.com.gda.business.address.model.decisionTree.RootAddressSelect;
import br.com.gda.info.InfoWritterFactory;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.action.ActionVisitorTemplateAction;
import br.com.gda.model.decisionTree.DeciTreeOption;
import br.com.gda.payService.payCustomer.info.PayCusInfo;
import br.com.gda.payService.payCustomer.info.PayCusMerger;

final class VisiPayCusMergeAddress extends ActionVisitorTemplateAction<PayCusInfo, AddressInfo> {
	public VisiPayCusMergeAddress(Connection conn, String schemaName) {
		super(conn, schemaName, PayCusInfo.class, AddressInfo.class);
	}
	
	
	
	@Override protected List<AddressInfo> toActionClassHook(List<PayCusInfo> recordInfos) {
		List<AddressInfo> results = new ArrayList<>();
		
		for (PayCusInfo eachRecord : recordInfos) {
			AddressInfo address = new AddressInfo();
			address.codOwner = eachRecord.codOwner;
			address.codPayCustomer = eachRecord.codPayCustomer;
			results.add(address);
		}		
		
		return results;
	}
	
	
	
	@Override protected ActionStd<AddressInfo> getActionHook(DeciTreeOption<AddressInfo> option) {
		return new RootAddressSelect(option).toAction();
	}
	
	
	
	@Override protected List<PayCusInfo> toBaseClassHook(List<PayCusInfo> baseInfos, List<AddressInfo> results) {
		InfoWritterFactory<PayCusInfo> merger = new PayCusMerger();
		return merger.merge(results, baseInfos);
	}
}
