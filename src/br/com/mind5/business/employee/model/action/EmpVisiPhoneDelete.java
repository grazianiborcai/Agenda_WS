package br.com.mind5.business.employee.model.action;

import java.util.List;

import br.com.mind5.business.employee.info.EmpInfo;
import br.com.mind5.business.phone.info.PhoneCopier;
import br.com.mind5.business.phone.info.PhoneInfo;
import br.com.mind5.business.phone.model.decisionTree.PhoneRootDelete;
import br.com.mind5.model.action.ActionVisitorTemplateAction;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class EmpVisiPhoneDelete extends ActionVisitorTemplateAction<EmpInfo, PhoneInfo> {
	public EmpVisiPhoneDelete(DeciTreeOption<EmpInfo> option) {
		super(option, EmpInfo.class, PhoneInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<PhoneInfo>> getTreeClassHook() {
		return PhoneRootDelete.class;
	}
	
	
	
	@Override protected List<PhoneInfo> toActionClassHook(List<EmpInfo> recordInfos) {
		return PhoneCopier.copyFromEmp(recordInfos);
	}
	
	
	
	@Override protected List<EmpInfo> toBaseClassHook(List<EmpInfo> baseInfos, List<PhoneInfo> results) {
		return baseInfos;
	}
}
