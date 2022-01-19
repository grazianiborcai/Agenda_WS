package br.com.mind5.business.petSnapshot.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.petSnapshot.info.PetsnapInfo;
import br.com.mind5.business.petSnapshot.model.action.LazyPetsnapMergePeteight;
import br.com.mind5.business.petSnapshot.model.action.LazyPetsnapMergePetype;
import br.com.mind5.business.petSnapshot.model.action.StdPetsnapMergeToSelect;
import br.com.mind5.business.petSnapshot.model.checker.PetsnapCheckLangu;
import br.com.mind5.business.petSnapshot.model.checker.PetsnapCheckOwner;
import br.com.mind5.business.petSnapshot.model.checker.PetsnapCheckRead;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;

public final class RootPetsnapSelect extends DeciTreeTemplateWrite<PetsnapInfo> {
	
	public RootPetsnapSelect(DeciTreeOption<PetsnapInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<PetsnapInfo> buildCheckerHook(DeciTreeOption<PetsnapInfo> option) {
		List<ModelChecker<PetsnapInfo>> queue = new ArrayList<>();		
		ModelChecker<PetsnapInfo> checker;
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new PetsnapCheckRead(checkerOption);
		queue.add(checker);		
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;	
		checker = new PetsnapCheckLangu(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;	
		checker = new PetsnapCheckOwner(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<PetsnapInfo>> buildActionsOnPassedHook(DeciTreeOption<PetsnapInfo> option) {
		List<ActionStd<PetsnapInfo>> actions = new ArrayList<>();
		
		ActionStd<PetsnapInfo> select = new StdPetsnapMergeToSelect(option);
		ActionLazy<PetsnapInfo> mergePetype = new LazyPetsnapMergePetype(option.conn, option.schemaName);
		ActionLazy<PetsnapInfo> mergePeteight = new LazyPetsnapMergePeteight(option.conn, option.schemaName);
		
		select.addPostAction(mergePetype);
		mergePetype.addPostAction(mergePeteight);
		
		actions.add(select);
		return actions;
	}
}
