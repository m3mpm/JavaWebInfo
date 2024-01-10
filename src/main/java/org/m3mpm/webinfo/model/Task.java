package org.m3mpm.webinfo.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


@Entity
@Table(name = "tasks")
public class Task {

    @Id
    @Column(name = "title")
    private String title;

    @Column(name = "parent_task")
    private String parentTask;

    @Column(name = "max_xp")
    private Integer maxXp;

    @OneToMany(mappedBy = "task", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Check> checks = new ArrayList<>();

    public Task() {
    }

    public Task(String title, String parentTask, Integer maxXp) {
        this.title = title;
        this.parentTask = parentTask;
        this.maxXp = maxXp;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getParentTask() {
        return parentTask;
    }

    public void setParentTask(String parentTask) {
        this.parentTask = parentTask;
    }

    public Integer getMaxXp() {
        return maxXp;
    }

    public void setMaxXp(Integer maxXp) {
        this.maxXp = maxXp;
    }

    public List<Check> getChecks() {
        return checks;
    }

    public void setChecks(List<Check> checks) {
        this.checks = checks;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Task task = (Task) o;
        return Objects.equals(title, task.title) && Objects.equals(parentTask, task.parentTask) && Objects.equals(maxXp, task.maxXp) && Objects.equals(checks, task.checks);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, parentTask, maxXp, checks);
    }

    @Override
    public String toString() {
        return "Task{" +
                "title='" + title + '\'' +
                ", parentTask='" + parentTask + '\'' +
                ", maxXp=" + maxXp +
                ", checks=" + checks +
                '}';
    }
}
