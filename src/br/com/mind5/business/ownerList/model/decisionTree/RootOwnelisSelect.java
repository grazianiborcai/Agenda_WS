package br.com.mind5.business.ownerList.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.ownerList.info.OwnelisInfo;
import br.com.mind5.business.ownerList.model.action.LazyOwnelisMergeBusarea;
import br.com.mind5.business.ownerList.model.action.LazyOwnelisMergeComplis;
import br.com.mind5.business.ownerList.model.action.StdOwnelisMergeToSelect;
import br.com.mind5.business.ownerList.model.checker.OwnelisCheckRead;
import br.com.mind5.model.action.ActionLazyV1;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelCheckerHelperQueueV2;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateReadV2;

public final class RootOwnelisSelect extends DeciTreeTemplateReadV2<OwnelisInfo> {

	public RootOwnelisSelect(DeciTreeOption<OwnelisInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelCheckerV1<OwnelisInfo> buildCheckerHook(DeciTreeOption<OwnelisInfo> option) {
		List<ModelCheckerV1<OwnelisInfo>> queue = new ArrayList<>();		
		ModelCheckerV1<OwnelisInfo> checker;
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new OwnelisCheckRead(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueueV2<>(queue);
	}
	
	
	
	@Override protected List<ActionStdV1<OwnelisInfo>> buildActionsOnPassedHook(DeciTreeOption<OwnelisInfo> option) {
		List<ActionStdV1<OwnelisInfo>> actions = new ArrayList<>();

		ActionStdV1<OwnelisInfo> select = new StdOwnelisMergeToSelect(option);
		ActionLazyV1<OwnelisInfo> mergeComplis = new LazyOwnelisMergeComplis(option.conn, option.schemaName);
		ActionLazyV1<OwnelisInfo> mergeBusarea = new LazyOwnelisMergeBusarea(option.conn, option.schemaName);
		
		select.addPostAction(mergeComplis);
		mergeComplis.addPostAction(mergeBusarea);
		
		actions.add(select);
		return actions;
	}
}
	