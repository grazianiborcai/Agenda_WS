package br.com.mind5.business.ownerList.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.ownerList.info.OwnelisInfo;
import br.com.mind5.business.ownerList.model.action.LazyOwnelisMergeBusarea;
import br.com.mind5.business.ownerList.model.action.LazyOwnelisMergeComplis;
import br.com.mind5.business.ownerList.model.action.LazyOwnelisMergeFimist;
import br.com.mind5.business.ownerList.model.action.StdOwnelisMergeToSelect;
import br.com.mind5.business.ownerList.model.checker.OwnelisCheckRead;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateRead;

public final class RootOwnelisSelect extends DeciTreeTemplateRead<OwnelisInfo> {

	public RootOwnelisSelect(DeciTreeOption<OwnelisInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<OwnelisInfo> buildCheckerHook(DeciTreeOption<OwnelisInfo> option) {
		List<ModelChecker<OwnelisInfo>> queue = new ArrayList<>();		
		ModelChecker<OwnelisInfo> checker;
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new OwnelisCheckRead(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<OwnelisInfo>> buildActionsOnPassedHook(DeciTreeOption<OwnelisInfo> option) {
		List<ActionStd<OwnelisInfo>> actions = new ArrayList<>();

		ActionStd<OwnelisInfo> select = new StdOwnelisMergeToSelect(option);
		ActionLazy<OwnelisInfo> mergeComplis = new LazyOwnelisMergeComplis(option.conn, option.schemaName);
		ActionLazy<OwnelisInfo> mergeBusarea = new LazyOwnelisMergeBusarea(option.conn, option.schemaName);
		ActionLazy<OwnelisInfo> mergeFimist = new LazyOwnelisMergeFimist(option.conn, option.schemaName);
		
		select.addPostAction(mergeComplis);
		mergeComplis.addPostAction(mergeBusarea);
		mergeBusarea.addPostAction(mergeFimist);
		
		actions.add(select);
		return actions;
	}
}
	