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
import br.com.mind5.payment.customerPartner.model.action.CusparVisiDaoUpdate;
import br.com.mind5.payment.customerPartner.model.action.CusparVisiEnforceLChanged;
import br.com.mind5.payment.customerPartner.model.action.CusparVisiMergeToUpdate;
import br.com.mind5.payment.customerPartner.model.action.CusparVisiNodeUpdateL1;
import br.com.mind5.payment.customerPartner.model.action.CusparVisiNodeUpdatePhoneL1;
import br.com.mind5.payment.customerPartner.model.checker.CusparCheckExist;
import br.com.mind5.payment.customerPartner.model.checker.CusparCheckLangu;
import br.com.mind5.payment.customerPartner.model.checker.CusparCheckRead;

public final class CusparRootUpdate extends DeciTreeTemplateRead<CusparInfo> {
	
	public CusparRootUpdate(DeciTreeOption<CusparInfo> option) {
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
		
		ActionStd <CusparInfo> mergeToUpdate   = new ActionStdCommom <CusparInfo>(option, CusparVisiMergeToUpdate.class);
		ActionLazy<CusparInfo> nodeUpdatePhone = new ActionLazyCommom<CusparInfo>(option, CusparVisiNodeUpdatePhoneL1.class);		
		ActionLazy<CusparInfo> enforceLChanged = new ActionLazyCommom<CusparInfo>(option, CusparVisiEnforceLChanged.class);
		ActionLazy<CusparInfo> update          = new ActionLazyCommom<CusparInfo>(option, CusparVisiDaoUpdate.class);
		ActionLazy<CusparInfo> nodeL1          = new ActionLazyCommom<CusparInfo>(option, CusparVisiNodeUpdateL1.class);
		
		
		mergeToUpdate.addPostAction(nodeUpdatePhone);
		nodeUpdatePhone.addPostAction(enforceLChanged);
		enforceLChanged.addPostAction(update);
		update.addPostAction(nodeL1);
		
		actions.add(mergeToUpdate);			
		return actions;
	}
}
