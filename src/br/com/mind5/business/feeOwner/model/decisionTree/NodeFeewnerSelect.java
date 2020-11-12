package br.com.mind5.business.feeOwner.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.feeOwner.info.FeewnerInfo;
import br.com.mind5.business.feeOwner.model.action.StdFeewnerMergeFeedef;
import br.com.mind5.business.feeOwner.model.action.StdFeewnerMergeToSelect;
import br.com.mind5.business.feeOwner.model.checker.FeewnerCheckExist;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelCheckerHelperQueueV2;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateReadV2;

public final class NodeFeewnerSelect extends DeciTreeTemplateReadV2<FeewnerInfo> {
	
	public NodeFeewnerSelect(DeciTreeOption<FeewnerInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelCheckerV1<FeewnerInfo> buildCheckerHook(DeciTreeOption<FeewnerInfo> option) {
		final boolean EXIST_ON_DB = true;
		
		List<ModelCheckerV1<FeewnerInfo>> queue = new ArrayList<>();		
		ModelCheckerV1<FeewnerInfo> checker;
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = EXIST_ON_DB;		
		checker = new FeewnerCheckExist(checkerOption);
		queue.add(checker);	
		
		return new ModelCheckerHelperQueueV2<>(queue);
	}
	
	
	
	@Override protected List<ActionStdV1<FeewnerInfo>> buildActionsOnPassedHook(DeciTreeOption<FeewnerInfo> option) {
		List<ActionStdV1<FeewnerInfo>> actions = new ArrayList<>();
		
		ActionStdV1<FeewnerInfo> select = new StdFeewnerMergeToSelect(option);
		actions.add(select);
		
		return actions;
	}
	
	
	
	@Override protected List<ActionStdV1<FeewnerInfo>> buildActionsOnFailedHook(DeciTreeOption<FeewnerInfo> option) {
		List<ActionStdV1<FeewnerInfo>> actions = new ArrayList<>();
		
		ActionStdV1<FeewnerInfo> mergeFeedef = new StdFeewnerMergeFeedef(option);
		actions.add(mergeFeedef);
		
		return actions;
	}
}
