package Patient.dao;

import org.springframework.stereotype.Repository;

import Patient.pojo.Type;

@Repository("typeDao")
public interface TypeDao {
    //根据id查询类型
	public Type getById(Integer id);
}
