package br.com.mind5.business.ownerList.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.ownerList.info.OwnelisInfo;
import br.com.mind5.business.ownerList.model.action.LazyOwnelisMergeComplis;
import br.com.mind5.business.ownerList.model.action.StdOwnelisMergeToSelect;
import br.com.mind5.business.ownerList.model.checker.OwnelisCheckRead;
import br.com.mind5.model.action.ActionLazyV1;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerQueue;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeReadTemplate;

public final class RootOwnelisSelect extends DeciTreeReadTemplate<OwnelisInfo> {

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
		
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStdV1<OwnelisInfo>> buildActionsOnPassedHook(DeciTreeOption<OwnelisInfo> option) {
		List<ActionStdV1<OwnelisInfo>> actions = new ArrayList<>();

		ActionStdV1<OwnelisInfo> select = new StdOwnelisMergeToSelect(option);
		ActionLazyV1<OwnelisInfo> mergeComplis = new LazyOwnelisMergeComplis(option.conn, option.schemaName);
		
		select.addPostAction(mergeComplis);
		
		actions.add(select);
		return actions;
	}
}
	