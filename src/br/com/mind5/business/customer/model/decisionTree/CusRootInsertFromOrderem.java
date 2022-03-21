package br.com.mind5.business.customer.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.customer.info.CusInfo;
import br.com.mind5.business.customer.model.action.CusVisiRootInsert;
import br.com.mind5.business.customer.model.action.CusVisiEnforceOrderemKey;
import br.com.mind5.business.customer.model.action.CusVisiEnforceUserData;
import br.com.mind5.business.customer.model.action.CusVisiMergeOrdemist;
import br.com.mind5.business.customer.model.action.CusVisiMergeUser;
import br.com.mind5.business.customer.model.checker.CusCheckInsertFromOrderem;
import br.com.mind5.business.customer.model.checker.CusCheckLangu;
import br.com.mind5.business.customer.model.checker.CusCheckOrderem;
import br.com.mind5.business.customer.model.checker.CusCheckOwner;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.commom.ActionLazyCommom;
import br.com.mind5.model.action.commom.ActionStdCommom;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;

public final class CusRootInsertFromOrderem extends DeciTreeTemplateWrite<CusInfo> {

	public CusRootInsertFromOrderem(DeciTreeOption<CusInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<CusInfo> buildCheckerHook(DeciTreeOption<CusInfo> option) {		
		List<ModelChecker<CusInfo>> queue = new ArrayList<>();		
		ModelChecker<CusInfo> checker;		
		ModelCheckerOption checkerOption;		
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new CusCheckInsertFromOrderem(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.expectedResult =  ModelCheckerOption.EXIST_ON_DB;		
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;		
		checker = new CusCheckLangu(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.expectedResult =  ModelCheckerOption.EXIST_ON_DB;		
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;		
		checker = new CusCheckOwner(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.expectedResult =  ModelCheckerOption.EXIST_ON_DB;		
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;		
		checker = new CusCheckOrderem(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<CusInfo>> buildActionsOnPassedHook(DeciTreeOption<CusInfo> option) {
		List<ActionStd<CusInfo>> actions = new ArrayList<>();		
		
		ActionStd<CusInfo> enforceOrderemKey = new ActionStdCommom<CusInfo>(option, CusVisiEnforceOrderemKey.class);
		ActionLazy<CusInfo> mergeOrdemist = new ActionLazyCommom<CusInfo>(option, CusVisiMergeOrdemist.class);
		ActionLazy<CusInfo> mergeUser = new ActionLazyCommom<CusInfo>(option, CusVisiMergeUser.class);
		ActionLazy<CusInfo> copyUserData = new ActionLazyCommom<CusInfo>(option, CusVisiEnforceUserData.class);		
		ActionLazy<CusInfo> insert = new ActionLazyCommom<CusInfo>(option, CusVisiRootInsert.class);
		
		enforceOrderemKey.addPostAction(mergeOrdemist);
		mergeOrdemist.addPostAction(mergeUser);
		mergeUser.addPostAction(copyUserData);
		copyUserData.addPostAction(insert);
		
		actions.add(enforceOrderemKey);	
		return actions;
	}
}
