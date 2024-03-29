package br.com.mind5.payment.customerPartner.model.decisionTree;

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
import br.com.mind5.payment.customerPartner.info.CusparInfo;
import br.com.mind5.payment.customerPartner.model.action.CusparVisiMergeToSelect;
import br.com.mind5.payment.customerPartner.model.action.CusparVisiNodeRefreshAddress;
import br.com.mind5.payment.customerPartner.model.action.CusparVisiNodeRefreshPhone;
import br.com.mind5.payment.customerPartner.model.action.CusparVisiRootUpdate;
import br.com.mind5.payment.customerPartner.model.checker.CusparCheckExist;
import br.com.mind5.payment.customerPartner.model.checker.CusparCheckLangu;
import br.com.mind5.payment.customerPartner.model.checker.CusparCheckRead;

public final class CusparRootRefresh extends DeciTreeTemplateRead<CusparInfo> {
	
	public CusparRootRefresh(DeciTreeOption<CusparInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<CusparInfo> buildCheckerHook(DeciTreeOption<CusparInfo> option) {
		List<ModelChecker<CusparInfo>> queue = new ArrayList<>();		
		ModelChecker<CusparInfo> checker;	
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new CusparCheckRead(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;	
		checker = new CusparCheckLangu(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;	
		checker = new CusparCheckExist(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<CusparInfo>> buildActionsOnPassedHook(DeciTreeOption<CusparInfo> option) {
		List<ActionStd<CusparInfo>> actions = new ArrayList<>();		
		
		ActionStd <CusparInfo> select   	  = new ActionStdCommom <CusparInfo>(option, CusparVisiMergeToSelect.class);
		ActionLazy<CusparInfo> refreshPhone   = new ActionLazyCommom<CusparInfo>(option, CusparVisiNodeRefreshPhone.class);
		ActionLazy<CusparInfo> refreshAddress = new ActionLazyCommom<CusparInfo>(option, CusparVisiNodeRefreshAddress.class);
		ActionLazy<CusparInfo> update         = new ActionLazyCommom<CusparInfo>(option, CusparVisiRootUpdate.class);
		
		select.addPostAction(refreshPhone);
		refreshPhone.addPostAction(refreshAddress);
		refreshAddress.addPostAction(update);
		
		actions.add(select);			
		return actions;
	}
}
