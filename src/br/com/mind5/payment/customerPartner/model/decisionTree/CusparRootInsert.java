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
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;
import br.com.mind5.payment.customerPartner.info.CusparInfo;
import br.com.mind5.payment.customerPartner.model.action.CusparVisiDaoInsert;
import br.com.mind5.payment.customerPartner.model.action.CusparVisiEnforceLChanged;
import br.com.mind5.payment.customerPartner.model.action.CusparVisiNodeAddressL1;
import br.com.mind5.payment.customerPartner.model.action.CusparVisiNodePhoneL1;
import br.com.mind5.payment.customerPartner.model.action.CusparVisiNodeUser;
import br.com.mind5.payment.customerPartner.model.action.CusparVisiRootSelect;
import br.com.mind5.payment.customerPartner.model.checker.CusparCheckCusparch;
import br.com.mind5.payment.customerPartner.model.checker.CusparCheckInsert;
import br.com.mind5.payment.customerPartner.model.checker.CusparCheckLangu;
import br.com.mind5.payment.customerPartner.model.checker.CusparCheckOwner;
import br.com.mind5.payment.customerPartner.model.checker.CusparCheckPaypar;
import br.com.mind5.payment.customerPartner.model.checker.CusparCheckUser;

public final class CusparRootInsert extends DeciTreeTemplateWrite<CusparInfo> {
	
	public CusparRootInsert(DeciTreeOption<CusparInfo> option) {
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
		checker = new CusparCheckInsert(checkerOption);
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
		checker = new CusparCheckOwner(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;	
		checker = new CusparCheckPaypar(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;	
		checker = new CusparCheckUser(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.NOT_FOUND;	
		checker = new CusparCheckCusparch(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<CusparInfo>> buildActionsOnPassedHook(DeciTreeOption<CusparInfo> option) {
		List<ActionStd<CusparInfo>> actions = new ArrayList<>();
		
		ActionStd <CusparInfo> nodeUser        = new ActionStdCommom <CusparInfo>(option, CusparVisiNodeUser.class);
		ActionLazy<CusparInfo> nodeAddress     = new ActionLazyCommom<CusparInfo>(option, CusparVisiNodeAddressL1.class);
		ActionLazy<CusparInfo> nodePhone       = new ActionLazyCommom<CusparInfo>(option, CusparVisiNodePhoneL1.class);
		ActionLazy<CusparInfo> enforceLChanged = new ActionLazyCommom<CusparInfo>(option, CusparVisiEnforceLChanged.class);			
		ActionLazy<CusparInfo> insert          = new ActionLazyCommom<CusparInfo>(option, CusparVisiDaoInsert.class);
		ActionLazy<CusparInfo> select          = new ActionLazyCommom<CusparInfo>(option, CusparVisiRootSelect.class);
		
		nodeUser.addPostAction(nodeAddress);
		nodeAddress.addPostAction(nodePhone);
		nodePhone.addPostAction(enforceLChanged);
		enforceLChanged.addPostAction(insert);
		insert.addPostAction(select);
		
		actions.add(nodeUser);
		return actions;
	}
}
