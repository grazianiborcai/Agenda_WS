package br.com.mind5.payment.storePartner.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.commom.ActionStdCommom;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;
import br.com.mind5.payment.storePartner.info.StoparInfo;
import br.com.mind5.payment.storePartner.model.action.StoparVisiDaoInsert;
import br.com.mind5.payment.storePartner.model.action.StoparVisiDaoUpdate;
import br.com.mind5.payment.storePartner.model.checker.StoparCheckSoftDelete;

public final class StoparNodeInsert extends DeciTreeTemplateWrite<StoparInfo> {
	
	public StoparNodeInsert(DeciTreeOption<StoparInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<StoparInfo> buildCheckerHook(DeciTreeOption<StoparInfo> option) {
		List<ModelChecker<StoparInfo>> queue = new ArrayList<>();		
		ModelChecker<StoparInfo> checker;
		ModelCheckerOption checkerOption;	
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.NOT_FOUND;		
		checker = new StoparCheckSoftDelete(checkerOption);
		queue.add(checker);	
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<StoparInfo>> buildActionsOnPassedHook(DeciTreeOption<StoparInfo> option) {
		List<ActionStd<StoparInfo>> actions = new ArrayList<>();
		
		ActionStd<StoparInfo> insert = new ActionStdCommom<StoparInfo>(option, StoparVisiDaoInsert.class);
		
		actions.add(insert);
		return actions;
	}
	
	
	
	@Override protected List<ActionStd<StoparInfo>> buildActionsOnFailedHook(DeciTreeOption<StoparInfo> option) {
		List<ActionStd<StoparInfo>> actions = new ArrayList<>();
		
		ActionStd<StoparInfo> update = new ActionStdCommom<StoparInfo>(option, StoparVisiDaoUpdate.class);
		
		actions.add(update);	
		return actions;
	}
}
