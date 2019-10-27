package br.com.mind5.payment.partnerMoip.creditCardMoip.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerQueue;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeWriteTemplate;
import br.com.mind5.payment.partnerMoip.creditCardMoip.info.CremoipInfo;
import br.com.mind5.payment.partnerMoip.creditCardMoip.model.action.LazyCremoipDelete;
import br.com.mind5.payment.partnerMoip.creditCardMoip.model.action.LazyCremoipEnforceSetup;
import br.com.mind5.payment.partnerMoip.creditCardMoip.model.action.LazyCremoipMergeSysEnviron;
import br.com.mind5.payment.partnerMoip.creditCardMoip.model.action.StdCremoipMergeSetupar;
import br.com.mind5.payment.partnerMoip.creditCardMoip.model.checker.CremoipCheckCusparData;
import br.com.mind5.payment.partnerMoip.creditCardMoip.model.checker.CremoipCheckDelete;
import br.com.mind5.payment.partnerMoip.creditCardMoip.model.checker.CremoipCheckSetupar;

public final class RootCremoipDelete extends DeciTreeWriteTemplate<CremoipInfo> {
	
	public RootCremoipDelete(DeciTreeOption<CremoipInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<CremoipInfo> buildDecisionCheckerHook(DeciTreeOption<CremoipInfo> option) {
		List<ModelChecker<CremoipInfo>> queue = new ArrayList<>();		
		ModelChecker<CremoipInfo> checker;	
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new CremoipCheckCusparData(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new CremoipCheckDelete(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;	
		checker = new CremoipCheckSetupar(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<CremoipInfo>> buildActionsOnPassedHook(DeciTreeOption<CremoipInfo> option) {
		List<ActionStd<CremoipInfo>> actions = new ArrayList<>();
		
		ActionStd<CremoipInfo> mergeSetupar = new StdCremoipMergeSetupar(option);
		ActionLazy<CremoipInfo> mergeSysEnviron = new LazyCremoipMergeSysEnviron(option.conn, option.schemaName);
		ActionLazy<CremoipInfo> enforceSetup = new LazyCremoipEnforceSetup(option.conn, option.schemaName);
		ActionLazy<CremoipInfo> delete = new LazyCremoipDelete(option.conn, option.schemaName);
		
		mergeSetupar.addPostAction(mergeSysEnviron);
		mergeSysEnviron.addPostAction(enforceSetup);
		enforceSetup.addPostAction(delete);
		
		actions.add(mergeSetupar);
		return actions;
	}
}
