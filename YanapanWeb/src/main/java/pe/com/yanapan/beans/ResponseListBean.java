package pe.com.yanapan.beans;

import java.util.List;

import pe.com.yanapan.model.Beneficiary;

/**
 * @author Manuel Castañeda
 *
 * @param <T> : es el objeto a mostrar
 * 
 * Información de las variables:
 * page : Cantidad de páginas a mostrar
 * total: Cantidad de registros
 * records: total de registros por pagina
 */

public class ResponseListBean<T> {

	private Integer page;
	private Integer total;
	private Integer records;
	private List<T> rows;

	public ResponseListBean() {
		super();
	}

	public ResponseListBean(Integer page,
			Integer total, Integer records, List<T> rows) {
		super();

		this.page = page;
		this.total = total;
		this.records = records;
		this.rows = rows;
	}

	

	public Integer getPage() {
		return page;
	}

	public void setPage(Integer page) {
		this.page = page;
	}

	public Integer getTotal() {
		return total;
	}

	public void setTotal(Integer total) {
		this.total = total;
	}

	public Integer getRecords() {
		return records;
	}

	public void setRecords(Integer records) {
		this.records = records;
	}

	public List<T> getRows() {
		return rows;
	}

	public void setRows(List<T> rows) {
		this.rows = rows;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ResponseListBean [page=");
		builder.append(page);
		builder.append(", total=");
		builder.append(total);
		builder.append(", records=");
		builder.append(records);
		builder.append(", rows=");
		builder.append(rows);
		builder.append("]");
		return builder.toString();
	}
	

}
