package br.com.mind5.payment.creditCardSearch.model.decisionTree;

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
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;
import br.com.mind5.payment.creditCardSearch.info.CrecarchInfo;
import br.com.mind5.payment.creditCardSearch.model.action.CrecarchVisiEnforceCusparIdKey;
import br.com.mind5.payment.creditCardSearch.model.action.CrecarchVisiRootSelect;
import br.com.mind5.payment.creditCardSearch.model.checker.CrecarchCheckLangu;
import br.com.mind5.payment.creditCardSearch.model.checker.CrecarchCheckReadCusparId;

public final class CrecarchRootSelectCusparId extends DeciTreeTemplateWrite<CrecarchInfo> {
	
	public CrecarchRootSelectCusparId(DeciTreeOption<CrecarchInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<CrecarchInfo> buildCheckerHook(DeciTreeOption<CrecarchInfo> option) {
		List<ModelChecker<CrecarchInfo>> queue = new ArrayList<>();		
		ModelChecker<CrecarchInfo> checker;	
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new CrecarchCheckReadCusparId(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;	
		checker = new CrecarchCheckLangu(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<CrecarchInfo>> buildActionsOnPassedHook(DeciTreeOption<CrecarchInfo> option) {
		List<ActionStd<CrecarchInfo>> actions = new ArrayList<>();
		
		ActionStd<CrecarchInfo>  enforceCusparIdKey = new ActionStdCommom<CrecarchInfo> (option, CrecarchVisiEnforceCusparIdKey.class);
		ActionLazy<CrecarchInfo> select             = new ActionLazyCommom<CrecarchInfo>(option, CrecarchVisiRootSelect.class);
		
		enforceCusparIdKey.addPostAction(select);
		
		actions.add(enforceCusparIdKey);
		return actions;
	}
}
