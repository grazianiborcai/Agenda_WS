package br.com.mind5.payment.storePartnerSnapshot.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.model.action.ActionLazyV1;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerQueue;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeReadTemplate;
import br.com.mind5.payment.storePartnerSnapshot.info.StoparnapInfo;
import br.com.mind5.payment.storePartnerSnapshot.model.action.LazyStoparnapMergePaypar;
import br.com.mind5.payment.storePartnerSnapshot.model.action.StdStoparnapMergeToSelect;
import br.com.mind5.payment.storePartnerSnapshot.model.checker.StoparnapCheckOwner;
import br.com.mind5.payment.storePartnerSnapshot.model.checker.StoparnapCheckRead;

public final class RootStoparnapSelect extends DeciTreeReadTemplate<StoparnapInfo> {
	
	public RootStoparnapSelect(DeciTreeOption<StoparnapInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<StoparnapInfo> buildDecisionCheckerHook(DeciTreeOption<StoparnapInfo> option) {
		List<ModelChecker<StoparnapInfo>> queue = new ArrayList<>();		
		ModelChecker<StoparnapInfo> checker;
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new StoparnapCheckRead(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;		
		checker = new StoparnapCheckOwner(checkerOption);
		queue.add(checker);	
		
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStdV1<StoparnapInfo>> buildActionsOnPassedHook(DeciTreeOption<StoparnapInfo> option) {
		List<ActionStdV1<StoparnapInfo>> actions = new ArrayList<>();
		
		ActionStdV1<StoparnapInfo> select = new StdStoparnapMergeToSelect(option);
		ActionLazyV1<StoparnapInfo> mergePayPartner = new LazyStoparnapMergePaypar(option.conn, option.schemaName);
		
		select.addPostAction(mergePayPartner);
		
		actions.add(select);
		return actions;
	}
}
