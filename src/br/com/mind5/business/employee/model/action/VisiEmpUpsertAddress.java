package br.com.mind5.business.employee.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.business.address.info.AddressCopier;
import br.com.mind5.business.address.info.AddressInfo;
import br.com.mind5.business.address.model.decisionTree.RootAddressUpsertdel;
import br.com.mind5.business.employee.info.EmpInfo;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.ActionVisitorTemplateAction;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiEmpUpsertAddress extends ActionVisitorTemplateAction<EmpInfo, AddressInfo> {
	public VisiEmpUpsertAddress(Connection conn, String schemaName) {
		super(conn, schemaName, EmpInfo.class, AddressInfo.class);
	}
	
	
	
	@Override protected List<AddressInfo> toActionClassHook(List<EmpInfo> recordInfos) {
		return AddressCopier.copyFromEmp(recordInfos);
	}
	
	
	
	@Override protected ActionStd<AddressInfo> getActionHook(DeciTreeOption<AddressInfo> option) {
		return new RootAddressUpsertdel(option).toAction();
	}
}
