package br.com.gda.payment.ownerPartner.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.model.action.ActionStd;
import br.com.gda.model.checker.ModelChecker;
import br.com.gda.model.checker.ModelCheckerOption;
import br.com.gda.model.checker.ModelCheckerQueue;
import br.com.gda.model.decisionTree.DeciTreeOption;
import br.com.gda.model.decisionTree.DeciTreeReadTemplate;
import br.com.gda.payment.ownerPartner.info.OwnparInfo;
import br.com.gda.payment.ownerPartner.model.action.StdOwnparMergeCounpar;
import br.com.gda.payment.ownerPartner.model.checker.OwnparCheckHasCountry;
import br.com.gda.payment.ownerPartner.model.checker.OwnparCheckCounpar;

public final class NodeOwnparSelectCounparL2 extends DeciTreeReadTemplate<OwnparInfo> {
	
	public NodeOwnparSelectCounparL2(DeciTreeOption<OwnparInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<OwnparInfo> buildDecisionCheckerHook(DeciTreeOption<OwnparInfo> option) {
		final boolean EXIST_ON_DB = true;
		final boolean HAS_ATTRIBUTE = true;
		
		List<ModelChecker<OwnparInfo>> queue = new ArrayList<>();		
		ModelChecker<OwnparInfo> checker;
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = HAS_ATTRIBUTE;		
		checker = new OwnparCheckHasCountry(checkerOption);
		queue.add(checker);	
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = EXIST_ON_DB;		
		checker = new OwnparCheckCounpar(checkerOption);
		queue.add(checker);	
		
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<OwnparInfo>> buildActionsOnPassedHook(DeciTreeOption<OwnparInfo> option) {
		List<ActionStd<OwnparInfo>> actions = new ArrayList<>();
		
		ActionStd<OwnparInfo> mergeCountry = new StdOwnparMergeCounpar(option);
		
		actions.add(mergeCountry);
		return actions;
	}
}
