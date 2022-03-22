package br.com.mind5.business.employee.model.action;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.address.info.AddressInfo;
import br.com.mind5.business.address.model.decisionTree.AddressRootDelete;
import br.com.mind5.business.employee.info.EmpInfo;
import br.com.mind5.model.action.ActionVisitorTemplateAction;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class EmpVisiAddressDelete extends ActionVisitorTemplateAction<EmpInfo, AddressInfo> {
	public EmpVisiAddressDelete(DeciTreeOption<EmpInfo> option) {
		super(option, EmpInfo.class, AddressInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<AddressInfo>> getTreeClassHook() {
		return AddressRootDelete.class;
	}
	
	
	
	@Override protected List<AddressInfo> toActionClassHook(List<EmpInfo> recordInfos) {
		List<AddressInfo> results = new ArrayList<>();		//TODO: Mover para Copier
		
		for (EmpInfo eachRecord : recordInfos) {
			results.addAll(eachRecord.addresses);
		}		
		
		return results;
	}
}
