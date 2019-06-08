package br.com.gda.legacy.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.gda.helper.MaterialStore;
import br.com.gda.helper.RecordMode;
import br.com.gda.legacy.dao.helper.MaterialStoreHelper;
import br.com.gda.legacy.db.ConnectionBD;
import br.com.gda.legacy.db.GdaDB;

public class MaterialStoreDAO extends ConnectionBD {

	public void insertMaterialStore(List<MaterialStore> materialStoreList) throws SQLException {

		Connection conn = null;
		PreparedStatement insertStmtT01 = null;

		try {
			conn = getConnection();
			conn.setAutoCommit(false);
			insertStmtT01 = conn.prepareStatement(MaterialStoreHelper.ST_IN_ALL_FIELD);

			for (MaterialStore materialStore : materialStoreList) {
				prepareInsert(insertStmtT01, materialStore);
			}

			insertStmtT01.executeBatch();
			conn.commit();

		} catch (SQLException e) {
			conn.rollback();
			throw e;
		} finally {
			closeConnection(conn, insertStmtT01);
		}
	}

	public void updateMaterialStore(List<MaterialStore> materialStoreList) throws SQLException {
		Connection conn = null;
		PreparedStatement insertStmtT01 = null;
		PreparedStatement updateStmtT01 = null;
		PreparedStatement deleteStmtT01 = null;

		try {
			conn = getConnection();
			conn.setAutoCommit(false);

			insertStmtT01 = conn.prepareStatement(MaterialStoreHelper.ST_IN_ALL_FIELD);
			updateStmtT01 = conn.prepareStatement(MaterialStoreHelper.ST_UP_ALL_FIELD_BY_FULL_KEY);

			MaterialStoreHelper materialStoreHelper = new MaterialStoreHelper();
			for (MaterialStore materialStore : materialStoreList) {

				if (materialStore.getRecordMode() != null && materialStore.getRecordMode().equals(RecordMode.ISNEW)) {
					prepareInsert(insertStmtT01, materialStore);

				} else {

					if (materialStore.getRecordMode() != null
							&& (materialStore.getRecordMode().equals(RecordMode.ISDELETED)
									|| materialStore.getRecordMode().equals(RecordMode.RECORD_DELETED))) {

						deleteStmtT01 = conn.prepareStatement(
								materialStoreHelper.prepareDelete(GdaDB.EQ, materialStore.getCodOwner(), GdaDB.EQ,
										materialStore.getCodMaterial(), GdaDB.EQ, materialStore.getCodStore()));

						deleteStmtT01.execute();

					} else {
						updateStmtT01.setBigDecimal(1,
								materialStore.getPriceStore() != null && !materialStore.getPriceStore().equals(0)
										? materialStore.getPriceStore() : materialStore.getPrice());
						updateStmtT01.setInt(2,
								materialStore.getDurationStore() != null
										&& !materialStore.getDurationStore().equals(0)
												? materialStore.getDurationStore() : materialStore.getDuration());
						updateStmtT01.setString(3, RecordMode.RECORD_OK);
						updateStmtT01.setString(4, materialStore.getCodCurrStore());
						updateStmtT01.setLong(5, materialStore.getCodOwner());
						updateStmtT01.setInt(6, materialStore.getCodMaterial());
						updateStmtT01.setInt(7, materialStore.getCodStore());

						updateStmtT01.addBatch();
					}
				}
			}

			insertStmtT01.executeBatch();
			updateStmtT01.executeBatch();
			conn.commit();

		} catch (SQLException e) {
			conn.rollback();
			throw e;
		} finally {
			closeConnection(conn, deleteStmtT01, insertStmtT01, updateStmtT01);
		}
	}

	public void deleteMaterialStore(long codOwner, int codMaterial, int codStore, int weekday) throws SQLException {
		Connection conn = null;
		PreparedStatement deleteStmt = null;

		try {
			conn = getConnection();
			conn.setAutoCommit(false);
			
			deleteStmt = conn.prepareStatement(MaterialStoreHelper.ST_FLAG_AS_DELETED);			
			deleteStmt.setString(1, RecordMode.RECORD_DELETED);
			deleteStmt.setLong(2, codOwner);
			deleteStmt.setInt(3, codStore);
			deleteStmt.setInt(4, codMaterial);
			deleteStmt.setInt(5, weekday);

			deleteStmt.execute();
			conn.commit();

		} catch (SQLException e) {
			conn.rollback();
			throw e;
		} finally {
			closeConnection(conn, deleteStmt);
		}
	}

	public List<MaterialStore> selectMaterialStore(List<Long> codOwner, List<Integer> codMaterial,
			List<Integer> codStore, List<Integer> codCategory, List<Integer> codType, List<String> image,
			List<String> barCode, List<String> recordMode, List<String> language, List<String> name,
			List<String> description, List<String> textLong) throws SQLException {

		ArrayList<MaterialStore> materialList = new ArrayList<MaterialStore>();
		Connection conn = null;
		PreparedStatement selectStmt = null;
		ResultSet resultSet = null;

		try {

			conn = getConnection();
			MaterialStoreHelper materialStoreHelper = new MaterialStoreHelper();

			selectStmt = conn.prepareStatement(materialStoreHelper.prepareSelect(codOwner, codMaterial, codStore,
					codCategory, codType, image, barCode, recordMode, language, name, description, textLong));

			resultSet = selectStmt.executeQuery();

			while (resultSet.next()) {
				materialStoreHelper.assignResult(materialList, resultSet);
			}

			return materialList;

		} catch (SQLException e) {
			throw e;
		} finally {
			closeConnection(conn, selectStmt, resultSet);
		}
	}

	private void prepareInsert(PreparedStatement insertStmtT01, MaterialStore materialStore) throws SQLException {

		insertStmtT01.setLong(1, materialStore.getCodOwner());
		insertStmtT01.setInt(2, materialStore.getCodMaterial());
		insertStmtT01.setInt(3, materialStore.getCodStore());
		insertStmtT01.setBigDecimal(4, materialStore.getPriceStore() != null && !materialStore.getPriceStore().equals(0)
				? materialStore.getPriceStore() : materialStore.getPrice());
		insertStmtT01.setInt(5,
				materialStore.getDurationStore() != null && !materialStore.getDurationStore().equals(0)
						? materialStore.getDurationStore() : materialStore.getDuration());
		insertStmtT01.setString(6, RecordMode.RECORD_OK);
		insertStmtT01.setString(7, materialStore.getCodCurrStore());
		insertStmtT01.setInt(8, materialStore.getWeekday());

		insertStmtT01.addBatch();
	}

}
