package br.com.mind5.business.material.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.material.info.MatInfo;
import br.com.mind5.business.material.model.action.LazyMatInsert;
import br.com.mind5.business.material.model.action.LazyMatInsertMatext;
import br.com.mind5.business.material.model.action.LazyMatMergeUsername;
import br.com.mind5.business.material.model.action.LazyMatNodeSnapshot;
import br.com.mind5.business.material.model.action.LazyMatRootSelect;
import br.com.mind5.business.material.model.action.StdMatEnforceLChanged;
import br.com.mind5.business.material.model.checker.MatCheckCateg;
import br.com.mind5.business.material.model.checker.MatCheckCurrency;
import br.com.mind5.business.material.model.checker.MatCheckGenField;
import br.com.mind5.business.material.model.checker.MatCheckGroup;
import br.com.mind5.business.material.model.checker.MatCheckLangu;
import br.com.mind5.business.material.model.checker.MatCheckOwner;
import br.com.mind5.business.material.model.checker.MatCheckType;
import br.com.mind5.business.material.model.checker.MatCheckUnit;
import br.com.mind5.business.material.model.checker.MatCheckUnitEach;
import br.com.mind5.business.material.model.checker.MatCheckUnitProduct;
import br.com.mind5.business.material.model.checker.MatCheckUnitService;
import br.com.mind5.business.material.model.checker.MatCheckWrite;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerQueue;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeWriteTemplate;

public final class RootMatInsert extends DeciTreeWriteTemplate<MatInfo> {
	
	public RootMatInsert(DeciTreeOption<MatInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<MatInfo> buildDecisionCheckerHook(DeciTreeOption<MatInfo> option) {
		final boolean EXIST_ON_DB = true;
		
		List<ModelChecker<MatInfo>> queue = new ArrayList<>();		
		ModelChecker<MatInfo> checker;	
		ModelCheckerOption checkerOption;
		
		checker = new MatCheckWrite();
		queue.add(checker);
		
		checker = new MatCheckGenField();
		queue.add(checker);
		
		checker = new MatCheckUnitEach();
		queue.add(checker);
		
		checker = new MatCheckUnitService();
		queue.add(checker);
		
		checker = new MatCheckUnitProduct();
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = EXIST_ON_DB;	
		checker = new MatCheckOwner(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = EXIST_ON_DB;	
		checker = new MatCheckLangu(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = EXIST_ON_DB;	
		checker = new MatCheckCurrency(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = EXIST_ON_DB;	
		checker = new MatCheckUnit(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = EXIST_ON_DB;	
		checker = new MatCheckCateg(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = EXIST_ON_DB;	
		checker = new MatCheckGroup(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = EXIST_ON_DB;	
		checker = new MatCheckType(checkerOption);
		queue.add(checker);
		
		//TODO: verificar a unidade de medida. Servico somente pode ter tempo e produto somente pode ter unidade
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<MatInfo>> buildActionsOnPassedHook(DeciTreeOption<MatInfo> option) {
		List<ActionStd<MatInfo>> actions = new ArrayList<>();		
		
		ActionStd<MatInfo> enforceLChanged = new StdMatEnforceLChanged(option);	
		ActionLazy<MatInfo> enforceLChangedBy = new LazyMatMergeUsername(option.conn, option.schemaName);
		ActionLazy<MatInfo> insertMat = new LazyMatInsert(option.conn, option.schemaName);	
		ActionLazy<MatInfo> insertMatext = new LazyMatInsertMatext(option.conn, option.schemaName);	
		ActionLazy<MatInfo> nodeSnapshot = new LazyMatNodeSnapshot(option.conn, option.schemaName);
		ActionLazy<MatInfo> select = new LazyMatRootSelect(option.conn, option.schemaName);		
		
		enforceLChanged.addPostAction(enforceLChangedBy);
		enforceLChangedBy.addPostAction(insertMat);
		insertMat.addPostAction(insertMatext);
		insertMatext.addPostAction(nodeSnapshot);	
		nodeSnapshot.addPostAction(select);
		
		actions.add(enforceLChanged);		
		return actions;
	}
}
