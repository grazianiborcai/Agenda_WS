package br.com.mind5.masterData.refundPolicyGroupItem.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.masterData.refundPolicyGroupItem.info.RefugritemInfo;
import br.com.mind5.masterData.refundPolicyGroupItem.model.action.LazyRefugritemMergeRefupo;
import br.com.mind5.masterData.refundPolicyGroupItem.model.action.StdRefugritemDaoSelect;
import br.com.mind5.masterData.refundPolicyGroupItem.model.checker.RefugritemCheckRead;
import br.com.mind5.model.action.ActionLazyV1;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelCheckerHelperQueueV2;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateReadV2;

public final class RootRefugritemSelect extends DeciTreeTemplateReadV2<RefugritemInfo> {
	
	public RootRefugritemSelect(DeciTreeOption<RefugritemInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelCheckerV1<RefugritemInfo> buildCheckerHook(DeciTreeOption<RefugritemInfo> option) {
		List<ModelCheckerV1<RefugritemInfo>> queue = new ArrayList<>();		
		ModelCheckerV1<RefugritemInfo> checker;
		ModelCheckerOption checkerOption;	
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new RefugritemCheckRead(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueueV2<>(queue);
	}
	
	
	
	@Override protected List<ActionStdV1<RefugritemInfo>> buildActionsOnPassedHook(DeciTreeOption<RefugritemInfo> option) {
		List<ActionStdV1<RefugritemInfo>> actions = new ArrayList<>();
		
		ActionStdV1<RefugritemInfo> select = new StdRefugritemDaoSelect(option);
		ActionLazyV1<RefugritemInfo> mergeRefupo = new LazyRefugritemMergeRefupo(option.conn, option.schemaName);
		
		select.addPostAction(mergeRefupo);
		
		actions.add(select);
		return actions;
	}
}
