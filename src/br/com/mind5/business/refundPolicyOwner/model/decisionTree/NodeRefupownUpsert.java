package br.com.mind5.business.refundPolicyOwner.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.refundPolicyOwner.info.RefupownInfo;
import br.com.mind5.business.refundPolicyOwner.model.action.StdRefupownDaoUpdate;
import br.com.mind5.business.refundPolicyOwner.model.checker.RefupownCheckExist;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;

public final class NodeRefupownUpsert extends DeciTreeTemplateWrite<RefupownInfo> {
	
	public NodeRefupownUpsert(DeciTreeOption<RefupownInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<RefupownInfo> buildCheckerHook(DeciTreeOption<RefupownInfo> option) {
		List<ModelChecker<RefupownInfo>> queue = new ArrayList<>();		
		ModelChecker<RefupownInfo> checker;	
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new RefupownCheckExist(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<RefupownInfo>> buildActionsOnPassedHook(DeciTreeOption<RefupownInfo> option) {
		List<ActionStd<RefupownInfo>> actions = new ArrayList<>();		
		
		ActionStd<RefupownInfo> update = new StdRefupownDaoUpdate(option);	
		
		actions.add(update);
		return actions;
	}
	
	
	
	@Override protected List<ActionStd<RefupownInfo>> buildActionsOnFailedHook(DeciTreeOption<RefupownInfo> option) {
		List<ActionStd<RefupownInfo>> actions = new ArrayList<>();		
		
		ActionStd<RefupownInfo> insert = new NodeRefupownInsert(option).toAction();	
		
		actions.add(insert);
		return actions;
	}
}
