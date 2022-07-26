package br.com.mind5.form.formAddressSearch.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.form.formAddressSearch.info.FormesarchInfo;
import br.com.mind5.form.formAddressSearch.model.action.FormesarchVisiMergeToSelect;
import br.com.mind5.form.formAddressSearch.model.checker.FormesarchCheckRead;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.commom.ActionStdCommom;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateRead;

public final class FormesarchRootSelect extends DeciTreeTemplateRead<FormesarchInfo> {
	
	public FormesarchRootSelect(DeciTreeOption<FormesarchInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<FormesarchInfo> buildCheckerHook(DeciTreeOption<FormesarchInfo> option) {
		List<ModelChecker<FormesarchInfo>> queue = new ArrayList<>();		
		ModelChecker<FormesarchInfo> checker;	
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new FormesarchCheckRead(checkerOption);
		queue.add(checker);
		
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<FormesarchInfo>> buildActionsOnPassedHook(DeciTreeOption<FormesarchInfo> option) {
		List<ActionStd<FormesarchInfo>> actions = new ArrayList<>();
		
		ActionStd<FormesarchInfo> mergeToSelect = new ActionStdCommom<FormesarchInfo>(option, FormesarchVisiMergeToSelect.class);
		
		actions.add(mergeToSelect);
		return actions;
	}
}
