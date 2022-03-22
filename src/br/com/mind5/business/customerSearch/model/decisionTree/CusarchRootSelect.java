package br.com.mind5.business.customerSearch.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.customerSearch.info.CusarchInfo;
import br.com.mind5.business.customerSearch.model.action.CusarchVisiMergePersolis;
import br.com.mind5.business.customerSearch.model.action.CusarchVisiMergeToSelect;
import br.com.mind5.business.customerSearch.model.checker.CusarchCheckRead;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.commom.ActionLazyCommom;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateRead;

public final class CusarchRootSelect extends DeciTreeTemplateRead<CusarchInfo> {
	
	public CusarchRootSelect(DeciTreeOption<CusarchInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<CusarchInfo> buildCheckerHook(DeciTreeOption<CusarchInfo> option) {
		List<ModelChecker<CusarchInfo>> queue = new ArrayList<>();		
		ModelChecker<CusarchInfo> checker;
		ModelCheckerOption checkerOption;	
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult =  ModelCheckerOption.SUCCESS;	
		checker = new CusarchCheckRead(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<CusarchInfo>> buildActionsOnPassedHook(DeciTreeOption<CusarchInfo> option) {
		List<ActionStd<CusarchInfo>> actions = new ArrayList<>();
		
		ActionStd<CusarchInfo> nodePerson = new CusarchNodePerson(option).toAction();
		ActionLazy<CusarchInfo> select = new ActionLazyCommom<CusarchInfo>(option, CusarchVisiMergeToSelect.class);
		ActionLazy<CusarchInfo> mergePersolis = new ActionLazyCommom<CusarchInfo>(option, CusarchVisiMergePersolis.class);
		
		nodePerson.addPostAction(select);
		select.addPostAction(mergePersolis);
		
		actions.add(nodePerson);
		return actions;
	}
}
