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
import br.com.mind5.business.customer.model.checker.CusCheckDelete;
import br.com.mind5.business.customer.model.checker.CusCheckExist;
import br.com.mind5.business.customer.model.checker.CusCheckLangu;
import br.com.mind5.business.customer.model.checker.CusCheckOwner;
import br.com.mind5.model.action.ActionLazyV1;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerQueue;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeWriteTemplate;

public final class RootCusDelete extends DeciTreeWriteTemplate<CusInfo> {
	
	public RootCusDelete(DeciTreeOption<CusInfo> option) {
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
		checker = new CusCheckDelete(checkerOption);
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
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult =  ModelCheckerOption.EXIST_ON_DB;		
		checker = new CusCheckExist(checkerOption);
		queue.add(checker);		
		
		 return new ModelCheckerQueue<CusInfo>(queue);
	}
	
	
	
	@Override protected List<ActionStdV1<CusInfo>> buildActionsOnPassedHook(DeciTreeOption<CusInfo> option) {
		List<ActionStdV1<CusInfo>> actions = new ArrayList<>();
		//TODO: Eliminar usuario ? Podem ser criados criados em momentos diferentes
		ActionStdV1<CusInfo> mergeToDelete = new StdCusMergeToDelete(option);
		ActionLazyV1<CusInfo> enforceLChanged = new LazyCusEnforceLChanged(option.conn, option.schemaName);
		ActionLazyV1<CusInfo> enforceLChangedBy = new LazyCusMergeUsername(option.conn, option.schemaName);
		ActionLazyV1<CusInfo> update = new LazyCusUpdate(option.conn, option.schemaName);
		ActionLazyV1<CusInfo> deleteAddress = new LazyCusNodeDeleteAddress(option.conn, option.schemaName);
		ActionLazyV1<CusInfo> deletePhone = new LazyCusNodeDeletePhone(option.conn, option.schemaName);
		ActionLazyV1<CusInfo> deletePerson = new LazyCusDeletePerson(option.conn, option.schemaName);
		ActionLazyV1<CusInfo> deleteCustomer = new LazyCusDelete(option.conn, option.schemaName);	
		
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
