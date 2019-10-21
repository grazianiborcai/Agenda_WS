package br.com.mind5.business.customer.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.customer.info.CusInfo;
import br.com.mind5.business.customer.model.action.LazyCusDelete;
import br.com.mind5.business.customer.model.action.LazyCusDeletePerson;
import br.com.mind5.business.customer.model.action.LazyCusEnforceLChanged;
import br.com.mind5.business.customer.model.action.LazyCusMergeUsername;
import br.com.mind5.business.customer.model.action.LazyCusNodeDeleteAddress;
import br.com.mind5.business.customer.model.action.LazyCusNodeDeletePhone;
import br.com.mind5.business.customer.model.action.LazyCusUpdate;
import br.com.mind5.business.customer.model.action.StdCusMergeToDelete;
import br.com.mind5.business.customer.model.checker.CusCheckExist;
import br.com.mind5.business.customer.model.checker.CusCheckLangu;
import br.com.mind5.business.customer.model.checker.CusCheckWrite;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerQueue;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeWriteTemplate;

public final class RootCusDelete extends DeciTreeWriteTemplate<CusInfo> {
	
	public RootCusDelete(DeciTreeOption<CusInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<CusInfo> buildDecisionCheckerHook(DeciTreeOption<CusInfo> option) {
		final boolean EXIST_ON_DB = true;	
		
		List<ModelChecker<CusInfo>> queue = new ArrayList<>();		
		ModelChecker<CusInfo> checker;
		ModelCheckerOption checkerOption;
		
		checker = new CusCheckWrite();
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.expectedResult = EXIST_ON_DB;		
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;		
		checker = new CusCheckLangu(checkerOption);
		queue.add(checker);
			
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = EXIST_ON_DB;		
		checker = new CusCheckExist(checkerOption);
		queue.add(checker);		
		
		 return new ModelCheckerQueue<CusInfo>(queue);
	}
	
	
	
	@Override protected List<ActionStd<CusInfo>> buildActionsOnPassedHook(DeciTreeOption<CusInfo> option) {
		List<ActionStd<CusInfo>> actions = new ArrayList<>();
		//TODO: Eliminar usuario ? Podem ser criados criados em momentos diferentes
		ActionStd<CusInfo> mergeToDelete = new StdCusMergeToDelete(option);
		ActionLazy<CusInfo> enforceLChanged = new LazyCusEnforceLChanged(option.conn, option.schemaName);
		ActionLazy<CusInfo> enforceLChangedBy = new LazyCusMergeUsername(option.conn, option.schemaName);
		ActionLazy<CusInfo> update = new LazyCusUpdate(option.conn, option.schemaName);
		ActionLazy<CusInfo> deleteAddress = new LazyCusNodeDeleteAddress(option.conn, option.schemaName);
		ActionLazy<CusInfo> deletePhone = new LazyCusNodeDeletePhone(option.conn, option.schemaName);
		ActionLazy<CusInfo> deletePerson = new LazyCusDeletePerson(option.conn, option.schemaName);
		ActionLazy<CusInfo> deleteCustomer = new LazyCusDelete(option.conn, option.schemaName);	
		
		mergeToDelete.addPostAction(enforceLChanged);
		enforceLChanged.addPostAction(enforceLChangedBy);
		enforceLChangedBy.addPostAction(update);
		
		update.addPostAction(deleteAddress);
		update.addPostAction(deletePhone);
		update.addPostAction(deletePerson);
		update.addPostAction(deleteCustomer);
		
		actions.add(mergeToDelete);		
		return actions;
	}
}
