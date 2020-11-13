package br.com.mind5.payment.storePartnerSnapshot.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateRead;
import br.com.mind5.payment.storePartnerSnapshot.info.StoparnapInfo;
import br.com.mind5.payment.storePartnerSnapshot.model.action.LazyStoparnapMergePaypar;
import br.com.mind5.payment.storePartnerSnapshot.model.action.StdStoparnapMergeToSelect;
import br.com.mind5.payment.storePartnerSnapshot.model.checker.StoparnapCheckOwner;
import br.com.mind5.payment.storePartnerSnapshot.model.checker.StoparnapCheckRead;

public final class RootStoparnapSelect extends DeciTreeTemplateRead<StoparnapInfo> {
	
	public RootStoparnapSelect(DeciTreeOption<StoparnapInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<StoparnapInfo> buildCheckerHook(DeciTreeOption<StoparnapInfo> option) {
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
		
		return new ModelCheckerHelperQueue<>(queue);
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
