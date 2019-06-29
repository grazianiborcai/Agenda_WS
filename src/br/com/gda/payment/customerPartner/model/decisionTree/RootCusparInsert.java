package br.com.gda.payment.customerPartner.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.payment.customerPartner.info.CusparInfo;
import br.com.gda.payment.customerPartner.model.action.LazyCusparEnforceLChanged;
import br.com.gda.payment.customerPartner.model.action.LazyCusparMergeAddresnap;
import br.com.gda.payment.customerPartner.model.action.LazyCusparMergeAddress;
import br.com.gda.payment.customerPartner.model.action.LazyCusparMergePhonap;
import br.com.gda.payment.customerPartner.model.action.LazyCusparMergePhone;
import br.com.gda.payment.customerPartner.model.action.LazyCusparMergeUser;
import br.com.gda.payment.customerPartner.model.action.LazyCusparMergeUserap;
import br.com.gda.payment.customerPartner.model.action.LazyCusparNodeInsert;
import br.com.gda.payment.customerPartner.model.action.LazyCusparRootSelect;
import br.com.gda.payment.customerPartner.model.action.StdCusparMergeUsername;
import br.com.gda.payment.customerPartner.model.checker.CusparCheckAddress;
import br.com.gda.payment.customerPartner.model.checker.CusparCheckInsert;
import br.com.gda.payment.customerPartner.model.checker.CusparCheckLangu;
import br.com.gda.payment.customerPartner.model.checker.CusparCheckOwner;
import br.com.gda.payment.customerPartner.model.checker.CusparCheckPaypar;
import br.com.gda.payment.customerPartner.model.checker.CusparCheckPhone;
import br.com.gda.payment.customerPartner.model.checker.CusparCheckUsername;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.action.ActionLazy;
import br.com.gda.model.checker.ModelChecker;
import br.com.gda.model.checker.ModelCheckerOption;
import br.com.gda.model.checker.ModelCheckerQueue;
import br.com.gda.model.decisionTree.DeciTreeOption;
import br.com.gda.model.decisionTree.DeciTreeWriteTemplate;

public final class RootCusparInsert extends DeciTreeWriteTemplate<CusparInfo> {
	
	public RootCusparInsert(DeciTreeOption<CusparInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<CusparInfo> buildDecisionCheckerHook(DeciTreeOption<CusparInfo> option) {
		final boolean EXIST_ON_DB = true;
		
		List<ModelChecker<CusparInfo>> queue = new ArrayList<>();		
		ModelChecker<CusparInfo> checker;	
		ModelCheckerOption checkerOption;
		
		checker = new CusparCheckInsert();
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = EXIST_ON_DB;	
		checker = new CusparCheckLangu(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = EXIST_ON_DB;	
		checker = new CusparCheckOwner(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = EXIST_ON_DB;	
		checker = new CusparCheckPaypar(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = EXIST_ON_DB;	
		checker = new CusparCheckUsername(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = EXIST_ON_DB;	
		checker = new CusparCheckAddress(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = EXIST_ON_DB;	
		checker = new CusparCheckPhone(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<CusparInfo>> buildActionsOnPassedHook(DeciTreeOption<CusparInfo> option) {
		List<ActionStd<CusparInfo>> actions = new ArrayList<>();
		
		ActionStd<CusparInfo> mergeUsername = new StdCusparMergeUsername(option);
		ActionLazy<CusparInfo> mergeUser = new LazyCusparMergeUser(option.conn, option.schemaName);		
		ActionLazy<CusparInfo> mergeUserSnapshot = new LazyCusparMergeUserap(option.conn, option.schemaName);	
		ActionLazy<CusparInfo> mergeAddress = new LazyCusparMergeAddress(option.conn, option.schemaName);
		ActionLazy<CusparInfo> mergeAddressSnapshot = new LazyCusparMergeAddresnap(option.conn, option.schemaName);
		ActionLazy<CusparInfo> mergePhone = new LazyCusparMergePhone(option.conn, option.schemaName);
		ActionLazy<CusparInfo> mergePhoneSnapshot = new LazyCusparMergePhonap(option.conn, option.schemaName);
		ActionLazy<CusparInfo> enforceLChanged = new LazyCusparEnforceLChanged(option.conn, option.schemaName);			
		ActionLazy<CusparInfo> insert = new LazyCusparNodeInsert(option.conn, option.schemaName);
		ActionLazy<CusparInfo> select = new LazyCusparRootSelect(option.conn, option.schemaName);
		
		mergeUsername.addPostAction(mergeUser);
		mergeUser.addPostAction(mergeUserSnapshot);
		mergeUserSnapshot.addPostAction(mergeAddress);		
		mergeAddress.addPostAction(mergeAddressSnapshot);		
		mergeAddressSnapshot.addPostAction(mergePhone);	
		mergePhone.addPostAction(mergePhoneSnapshot);			
		mergePhoneSnapshot.addPostAction(enforceLChanged);			
		enforceLChanged.addPostAction(insert);
		insert.addPostAction(select);
		
		actions.add(mergeUsername);
		return actions;
	}
}
