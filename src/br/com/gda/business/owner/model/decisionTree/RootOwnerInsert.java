package br.com.gda.business.owner.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.owner.info.OwnerInfo;
import br.com.gda.business.owner.model.action.LazyOwnerEnforceLChangedBy;
import br.com.gda.business.owner.model.action.LazyOwnerInsert;
import br.com.gda.business.owner.model.action.LazyOwnerNodeInsertComp;
import br.com.gda.business.owner.model.action.LazyOwnerNodeInsertPerson;
import br.com.gda.business.owner.model.action.LazyOwnerNodeInsertUser;
import br.com.gda.business.owner.model.action.LazyOwnerNodeUpsertAddress;
import br.com.gda.business.owner.model.action.LazyOwnerNodeUpsertPhone;
import br.com.gda.business.owner.model.action.LazyOwnerRootSelect;
import br.com.gda.business.owner.model.action.LazyOwnerUpdate;
import br.com.gda.business.owner.model.action.StdOwnerEnforceLChanged;
import br.com.gda.business.owner.model.checker.OwnerCheckInsert;
import br.com.gda.business.owner.model.checker.OwnerCheckLangu;
import br.com.gda.business.owner.model.checker.OwnerCheckTechField;
import br.com.gda.business.owner.model.checker.OwnerCheckWriteAddress;
import br.com.gda.business.owner.model.checker.OwnerCheckWritePhone;
import br.com.gda.model.action.ActionLazy;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.checker.ModelChecker;
import br.com.gda.model.checker.ModelCheckerOption;
import br.com.gda.model.checker.ModelCheckerQueue;
import br.com.gda.model.decisionTree.DeciTreeOption;
import br.com.gda.model.decisionTree.DeciTreeWriteTemplate;

public final class RootOwnerInsert extends DeciTreeWriteTemplate<OwnerInfo> {
	
	public RootOwnerInsert(DeciTreeOption<OwnerInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<OwnerInfo> buildDecisionCheckerHook(DeciTreeOption<OwnerInfo> option) {
		List<ModelChecker<OwnerInfo>> queue = new ArrayList<>();		
		ModelChecker<OwnerInfo> checker;
		ModelCheckerOption checkerOption;	
		
		checker = new OwnerCheckInsert();
		queue.add(checker);
		
		checker = new OwnerCheckTechField();
		queue.add(checker);
		
		checker = new OwnerCheckWritePhone();
		queue.add(checker);
		
		checker = new OwnerCheckWriteAddress();
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;		
		checker = new OwnerCheckLangu(checkerOption);
		queue.add(checker);	
		
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<OwnerInfo>> buildActionsOnPassedHook(DeciTreeOption<OwnerInfo> option) {
		List<ActionStd<OwnerInfo>> actions = new ArrayList<>();
		
		ActionStd<OwnerInfo> enforceLChanged = new StdOwnerEnforceLChanged(option);
		ActionLazy<OwnerInfo> insertOwner = new LazyOwnerInsert(option.conn, option.schemaName);
		ActionLazy<OwnerInfo> insertUser = new LazyOwnerNodeInsertUser(option.conn, option.schemaName);	
		ActionLazy<OwnerInfo> enforceLChangedBy = new LazyOwnerEnforceLChangedBy(option.conn, option.schemaName);	
		ActionLazy<OwnerInfo> insertPerson = new LazyOwnerNodeInsertPerson(option.conn, option.schemaName);			
		ActionLazy<OwnerInfo> insertComp = new LazyOwnerNodeInsertComp(option.conn, option.schemaName);	
		ActionLazy<OwnerInfo> updateOwner = new LazyOwnerUpdate(option.conn, option.schemaName);
		ActionLazy<OwnerInfo> upsertAddress = new LazyOwnerNodeUpsertAddress(option.conn, option.schemaName);
		ActionLazy<OwnerInfo> upsertPhone = new LazyOwnerNodeUpsertPhone(option.conn, option.schemaName);	
		ActionLazy<OwnerInfo> select = new LazyOwnerRootSelect(option.conn, option.schemaName);	
		
		enforceLChanged.addPostAction(insertOwner);
		insertOwner.addPostAction(insertUser);
		insertUser.addPostAction(enforceLChangedBy);	
		enforceLChangedBy.addPostAction(insertPerson);		
		insertPerson.addPostAction(insertComp);		
		insertComp.addPostAction(updateOwner);	
		updateOwner.addPostAction(upsertAddress);		
		updateOwner.addPostAction(upsertPhone);			
		updateOwner.addPostAction(select);
		
		actions.add(enforceLChanged);	
		return actions;
	}
}
