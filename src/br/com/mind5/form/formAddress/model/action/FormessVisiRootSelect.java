package br.com.mind5.form.formAddress.model.action;

import java.util.List;

import br.com.mind5.form.formAddress.info.FormessInfo;
import br.com.mind5.form.formAddress.model.decisionTree.FormessRootSelect;
import br.com.mind5.model.action.ActionVisitorTemplateAction;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class FormessVisiRootSelect extends ActionVisitorTemplateAction<FormessInfo, FormessInfo> {

	public FormessVisiRootSelect(DeciTreeOption<FormessInfo> option) {
		super(option, FormessInfo.class, FormessInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<FormessInfo>> getTreeClassHook() {
		return FormessRootSelect.class;
	}
	
	
	
	@Override protected List<FormessInfo> toBaseClassHook(List<FormessInfo> baseInfos, List<FormessInfo> results) {
		return results;
	}
}
