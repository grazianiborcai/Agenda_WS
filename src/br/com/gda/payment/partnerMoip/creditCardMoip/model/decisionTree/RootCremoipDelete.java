package br.com.gda.payment.partnerMoip.creditCardMoip.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.model.action.ActionStd;
import br.com.gda.model.action.ActionLazy;
import br.com.gda.model.checker.ModelChecker;
import br.com.gda.model.checker.ModelCheckerOption;
import br.com.gda.model.checker.ModelCheckerQueue;
import br.com.gda.model.decisionTree.DeciTreeOption;
import br.com.gda.model.decisionTree.DeciTreeWriteTemplate;
import br.com.gda.payment.partnerMoip.creditCardMoip.info.CremoipInfo;
import br.com.gda.payment.partnerMoip.creditCardMoip.model.action.LazyCremoipDelete;
import br.com.gda.payment.partnerMoip.creditCardMoip.model.action.LazyCremoipEnforceSetup;
import br.com.gda.payment.partnerMoip.creditCardMoip.model.action.StdCremoipMergeSetupar;
import br.com.gda.payment.partnerMoip.creditCardMoip.model.checker.CremoipCheckCusparData;
import br.com.gda.payment.partnerMoip.creditCardMoip.model.checker.CremoipCheckDelete;
import br.com.gda.payment.partnerMoip.creditCardMoip.model.checker.CremoipCheckSetupar;

public final class RootCremoipDelete extends DeciTreeWriteTemplate<CremoipInfo> {
	
	public RootCremoipDelete(DeciTreeOption<CremoipInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<CremoipInfo> buildDecisionCheckerHook(DeciTreeOption<CremoipInfo> option) {
		final boolean EXIST_ON_DB = true;
		
		List<ModelChecker<CremoipInfo>> queue = new ArrayList<>();		
		ModelChecker<CremoipInfo> checker;	
		ModelCheckerOption checkerOption;
		
		checker = new CremoipCheckCusparData();
		queue.add(checker);
		
		checker = new CremoipCheckDelete();
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = EXIST_ON_DB;	
		checker = new CremoipCheckSetupar(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<CremoipInfo>> buildActionsOnPassedHook(DeciTreeOption<CremoipInfo> option) {
		List<ActionStd<CremoipInfo>> actions = new ArrayList<>();
		
		ActionStd<CremoipInfo> mergeSetupar = new StdCremoipMergeSetupar(option);
		ActionLazy<CremoipInfo> enforceSetup = new LazyCremoipEnforceSetup(option.conn, option.schemaName);
		ActionLazy<CremoipInfo> delete = new LazyCremoipDelete(option.conn, option.schemaName);
		
		mergeSetupar.addPostAction(enforceSetup);
		enforceSetup.addPostAction(delete);
		
		actions.add(mergeSetupar);
		return actions;
	}
}
