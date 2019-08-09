package br.com.gda.payment.storePartnerSnapshot.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.model.action.ActionLazy;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.checker.ModelChecker;
import br.com.gda.model.checker.ModelCheckerOption;
import br.com.gda.model.checker.ModelCheckerQueue;
import br.com.gda.model.decisionTree.DeciTreeOption;
import br.com.gda.model.decisionTree.DeciTreeReadTemplate;
import br.com.gda.payment.storePartnerSnapshot.info.StoparnapInfo;
import br.com.gda.payment.storePartnerSnapshot.model.action.LazyStoparnapMergePaypar;
import br.com.gda.payment.storePartnerSnapshot.model.action.StdStoparnapMergeToSelect;
import br.com.gda.payment.storePartnerSnapshot.model.checker.StoparnapCheckOwner;
import br.com.gda.payment.storePartnerSnapshot.model.checker.StoparnapCheckRead;

public final class RootStoparnapSelect extends DeciTreeReadTemplate<StoparnapInfo> {
	
	public RootStoparnapSelect(DeciTreeOption<StoparnapInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<StoparnapInfo> buildDecisionCheckerHook(DeciTreeOption<StoparnapInfo> option) {
		final boolean EXIST_ON_DB = true;
		
		List<ModelChecker<StoparnapInfo>> queue = new ArrayList<>();		
		ModelChecker<StoparnapInfo> checker;
		ModelCheckerOption checkerOption;
		
		checker = new StoparnapCheckRead();
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = EXIST_ON_DB;		
		checker = new StoparnapCheckOwner(checkerOption);
		queue.add(checker);	
		
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<StoparnapInfo>> buildActionsOnPassedHook(DeciTreeOption<StoparnapInfo> option) {
		List<ActionStd<StoparnapInfo>> actions = new ArrayList<>();
		
		ActionStd<StoparnapInfo> select = new StdStoparnapMergeToSelect(option);
		ActionLazy<StoparnapInfo> mergePayPartner = new LazyStoparnapMergePaypar(option.conn, option.schemaName);
		
		select.addPostAction(mergePayPartner);
		
		actions.add(select);
		return actions;
	}
}
