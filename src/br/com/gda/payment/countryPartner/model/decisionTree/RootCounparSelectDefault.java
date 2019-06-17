package br.com.gda.payment.countryPartner.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.model.action.ActionLazy;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.checker.ModelChecker;
import br.com.gda.model.checker.ModelCheckerQueue;
import br.com.gda.model.decisionTree.DeciTreeOption;
import br.com.gda.model.decisionTree.DeciTreeReadTemplate;
import br.com.gda.payment.countryPartner.info.CounparInfo;
import br.com.gda.payment.countryPartner.model.action.LazyCounparRootSelect;
import br.com.gda.payment.countryPartner.model.action.StdCounparEnforceDefault;
import br.com.gda.payment.countryPartner.model.checker.CounparCheckRead;

public final class RootCounparSelectDefault extends DeciTreeReadTemplate<CounparInfo> {
	
	public RootCounparSelectDefault(DeciTreeOption<CounparInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<CounparInfo> buildDecisionCheckerHook(DeciTreeOption<CounparInfo> option) {
		List<ModelChecker<CounparInfo>> queue = new ArrayList<>();		
		ModelChecker<CounparInfo> checker;
		
		checker = new CounparCheckRead();
		queue.add(checker);
		
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<CounparInfo>> buildActionsOnPassedHook(DeciTreeOption<CounparInfo> option) {
		List<ActionStd<CounparInfo>> actions = new ArrayList<>();
		
		ActionStd<CounparInfo> enforceDefault = new StdCounparEnforceDefault(option);
		ActionLazy<CounparInfo> rootSelect = new LazyCounparRootSelect(option.conn, option.schemaName);
		
		enforceDefault.addPostAction(rootSelect);
		
		actions.add(enforceDefault);
		return actions;
	}
}
