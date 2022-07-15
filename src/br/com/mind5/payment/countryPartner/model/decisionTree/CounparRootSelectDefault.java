package br.com.mind5.payment.countryPartner.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.commom.ActionLazyCommom;
import br.com.mind5.model.action.commom.ActionStdCommom;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateRead;
import br.com.mind5.payment.countryPartner.info.CounparInfo;
import br.com.mind5.payment.countryPartner.model.action.CounparVisiRootSelect;
import br.com.mind5.payment.countryPartner.model.action.CounparVisiEnforceDefault;
import br.com.mind5.payment.countryPartner.model.action.CounparVisiMergeCounparch;
import br.com.mind5.payment.countryPartner.model.checker.CounparCheckDefault;

public final class CounparRootSelectDefault extends DeciTreeTemplateRead<CounparInfo> {
	
	public CounparRootSelectDefault(DeciTreeOption<CounparInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<CounparInfo> buildCheckerHook(DeciTreeOption<CounparInfo> option) {
		List<ModelChecker<CounparInfo>> queue = new ArrayList<>();		
		ModelChecker<CounparInfo> checker;
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new CounparCheckDefault(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<CounparInfo>> buildActionsOnPassedHook(DeciTreeOption<CounparInfo> option) {
		List<ActionStd<CounparInfo>> actions = new ArrayList<>();
		
		ActionStd<CounparInfo> enforceDefault = new ActionStdCommom<CounparInfo>(option, CounparVisiEnforceDefault.class);
		ActionLazy<CounparInfo> mergeCounparch = new ActionLazyCommom<CounparInfo>(option, CounparVisiMergeCounparch.class);
		ActionLazy<CounparInfo> select = new ActionLazyCommom<CounparInfo>(option, CounparVisiRootSelect.class);
		
		enforceDefault.addPostAction(mergeCounparch);
		mergeCounparch.addPostAction(select);
		
		actions.add(enforceDefault);
		return actions;
	}
}
