## No.177 第N高的薪水
编写一个 SQL 查询，获取 Employee 表中第 n 高的薪水（Salary）。

> Tips: offset 后面不能跟表达式，只能接受正整数和单一变量

这一版通过了，但是可能有问题
~~~
CREATE FUNCTION getNthHighestSalary(N INT) RETURNS INT
BEGIN
    SET N := N - 1;
  RETURN (
      # Write your MySQL query statement below.
      select distinct Salary from Employee order by Salary desc limit 1 offset N
  );
END
~~~

~~~
CREATE FUNCTION getNthHighestSalary ( N INT ) RETURNS INT BEGIN
DECLARE m INT;
SET m = N - 1;
RETURN ( # Write your MySQL query statement below.
SELECT ifnull( ( SELECT DISTINCT salary FROM Employee ORDER BY salary DESC LIMIT m, 1 ), NULL ) );
END
~~~


## No.178
编写一个 SQL 查询来实现分数排名。
如果两个分数相同，则两个分数排名（Rank）相同。请注意，平分后的下一个名次应该是下一个连续的整数值。换句话说，名次之间不应该有“间隔”。

> Tips: Rank 是关键字

~~~
select a.Score as Score,
(select count(distinct b.Score) from Scores b where b.Score >= a.Score) as `Rank`
from Scores a
order by a.Score DESC
~~~


## No.185
 部门工资前三高的所有员工

> Tips: 首先需要实现找前3高的员工
>　公司内前三高的员工意味着工资比该员工高的工资最多有2个，不会超过3 

~~~
SELECT c.Name AS `Department`, a.Name AS `Employee`, a.Salary
FROM Employee a, Department c
WHERE (
		SELECT count(DISTINCT b.Salary)
		FROM Employee b
		WHERE b.Salary > a.Salary
			AND b.DepartmentId = a.DepartmentId
	) < 3
	AND a.DepartmentId = c.Id
~~~

## No.196 删除重复的电子邮箱
Tips: 删除语句不能直接delete select from, 否则会提示: You can't specify target table 'Person' for update in FROM clause
~~~
# 查出对应的记录，进行删除
DELETE p1 FROM Person p1,
    Person p2
WHERE
    p1.Email = p2.Email AND p1.Id > p2.Id;


# 找到重复的最小的id, 然后删除不在里面的id
DELETE FROM Person
WHERE id NOT IN (
		SELECT id
		FROM (
			SELECT min(Id) AS id
			FROM Person
			GROUP BY Email
		) t
	);
~~~
