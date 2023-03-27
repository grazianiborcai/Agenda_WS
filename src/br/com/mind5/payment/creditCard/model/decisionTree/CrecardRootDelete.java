package br.com.mind5.payment.creditCard.model.decisionTree;

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
import br.com.mind5.payment.creditCard.info.CrecardInfo;
import br.com.mind5.payment.creditCard.model.action.CrecardVisiMergeToDelete;
import br.com.mind5.payment.creditCard.model.action.CrecardVisiNodeAuth;
import br.com.mind5.payment.creditCard.model.action.CrecardVisiNodeDelete;
import br.com.mind5.payment.creditCard.model.checker.CrecardCheckDelete;
import br.com.mind5.payment.creditCard.model.checker.CrecardCheckExist;
import br.com.mind5.payment.creditCard.model.checker.CrecardCheckUsername;

public final class CrecardRootDelete extends DeciTreeTemplateWrite<CrecardInfo> {
	
	public CrecardRootDelete(DeciTreeOption<CrecardInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<CrecardInfo> buildCheckerHook(DeciTreeOption<CrecardInfo> option) {
		List<ModelChecker<CrecardInfo>> queue = new ArrayList<>();		
		ModelChecker<CrecardInfo> checker;
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new CrecardCheckDelete(checkerOption);
		queue.add(checker);
			
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;		
		checker = new CrecardCheckExist(checkerOption);
		queue.add(checker);	
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;		
		checker = new CrecardCheckUsername(checkerOption);
		queue.add(checker);	

		return new ModelCheckerHelperQueue<CrecardInfo>(queue);
	}
	
	
	
	@Override protected List<ActionStd<CrecardInfo>> buildActionsOnPassedHook(DeciTreeOption<CrecardInfo> option) {
		List<ActionStd<CrecardInfo>> actions = new ArrayList<>();
		
		ActionStd <CrecardInfo> mergeToDelete = new ActionStdCommom <CrecardInfo>(option, CrecardVisiMergeToDelete.class);
		ActionLazy<CrecardInfo> nodeAuth      = new ActionLazyCommom<CrecardInfo>(option, CrecardVisiNodeAuth.class);
		ActionLazy<CrecardInfo> nodeDelete    = new ActionLazyCommom<CrecardInfo>(option, CrecardVisiNodeDelete.class);
		
		mergeToDelete.addPostAction(nodeAuth);
		nodeAuth.addPostAction(nodeDelete);
		
		actions.add(mergeToDelete);
		return actions;
	}
}
