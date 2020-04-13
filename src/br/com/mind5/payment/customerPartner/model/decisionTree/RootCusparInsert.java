package br.com.mind5.payment.customerPartner.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.model.action.ActionLazyV1;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerHelperQueueV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWriteV1;
import br.com.mind5.payment.customerPartner.info.CusparInfo;
import br.com.mind5.payment.customerPartner.model.action.LazyCusparEnforceLChanged;
import br.com.mind5.payment.customerPartner.model.action.LazyCusparMergeAddress;
import br.com.mind5.payment.customerPartner.model.action.LazyCusparMergePhone;
import br.com.mind5.payment.customerPartner.model.action.LazyCusparNodeInsert;
import br.com.mind5.payment.customerPartner.model.action.LazyCusparRootSelect;
import br.com.mind5.payment.customerPartner.model.action.StdCusparMergeUselis;
import br.com.mind5.payment.customerPartner.model.checker.CusparCheckAddarch;
import br.com.mind5.payment.customerPartner.model.checker.CusparCheckAddress;
import br.com.mind5.payment.customerPartner.model.checker.CusparCheckCusparch;
import br.com.mind5.payment.customerPartner.model.checker.CusparCheckInsert;
import br.com.mind5.payment.customerPartner.model.checker.CusparCheckLangu;
import br.com.mind5.payment.customerPartner.model.checker.CusparCheckOwner;
import br.com.mind5.payment.customerPartner.model.checker.CusparCheckPaypar;
import br.com.mind5.payment.customerPartner.model.checker.CusparCheckPhonarch;
import br.com.mind5.payment.customerPartner.model.checker.CusparCheckPhone;
import br.com.mind5.payment.customerPartner.model.checker.CusparCheckUser;

public final class RootCusparInsert extends DeciTreeTemplateWriteV1<CusparInfo> {
	
	public RootCusparInsert(DeciTreeOption<CusparInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelCheckerV1<CusparInfo> buildCheckerHook(DeciTreeOption<CusparInfo> option) {
		List<ModelCheckerV1<CusparInfo>> queue = new ArrayList<>();		
		ModelCheckerV1<CusparInfo> checker;	
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
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;	
		checker = new CusparCheckAddress(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;	
		checker = new CusparCheckPhone(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;	
		checker = new CusparCheckAddarch(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;	
		checker = new CusparCheckPhonarch(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueueV2<>(queue);
	}
	
	
	
	@Override protected List<ActionStdV1<CusparInfo>> buildActionsOnPassedHook(DeciTreeOption<CusparInfo> option) {
		List<ActionStdV1<CusparInfo>> actions = new ArrayList<>();
		
		ActionStdV1<CusparInfo> mergeUselis = new StdCusparMergeUselis(option);
		ActionLazyV1<CusparInfo> mergeAddress = new LazyCusparMergeAddress(option.conn, option.schemaName);
		ActionLazyV1<CusparInfo> mergePhone = new LazyCusparMergePhone(option.conn, option.schemaName);
		ActionLazyV1<CusparInfo> enforceLChanged = new LazyCusparEnforceLChanged(option.conn, option.schemaName);			
		ActionLazyV1<CusparInfo> insert = new LazyCusparNodeInsert(option.conn, option.schemaName);
		ActionLazyV1<CusparInfo> select = new LazyCusparRootSelect(option.conn, option.schemaName);
		
		mergeUselis.addPostAction(mergeAddress);		
		mergeAddress.addPostAction(mergePhone);	
		mergePhone.addPostAction(enforceLChanged);			
		enforceLChanged.addPostAction(insert);
		insert.addPostAction(select);
		
		actions.add(mergeUselis);
		return actions;
	}
}
