package br.com.mind5.business.employee.model.action;

import java.util.List;

import br.com.mind5.business.address.info.AddressCopier;
import br.com.mind5.business.address.info.AddressInfo;
import br.com.mind5.business.address.model.decisionTree.AddressRootUpsertdel;
import br.com.mind5.business.employee.info.EmpInfo;
import br.com.mind5.model.action.ActionVisitorTemplateAction;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class EmpVisiAddressUpsert extends ActionVisitorTemplateAction<EmpInfo, AddressInfo> {
	
	public EmpVisiAddressUpsert(DeciTreeOption<EmpInfo> option) {
		super(option, EmpInfo.class, AddressInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<AddressInfo>> getTreeClassHook() {
		return AddressRootUpsertdel.class;
	}
	
	
	
	@Override protected List<AddressInfo> toActionClassHook(List<EmpInfo> recordInfos) {
		return AddressCopier.copyFromEmp(recordInfos);
	}
}
