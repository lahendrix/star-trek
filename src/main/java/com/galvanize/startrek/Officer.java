package com.galvanize.startrek;

final class Officer {
    private Long id;
    private Rank rank;
    private String first;
    private String last;

    public Officer() {}

    public Officer(Rank rank, String first, String last) {
        this.rank = rank;
        this.first = first;
        this.last = last;
    }

    public Officer(Long id, Rank rank, String first, String last) {
        this.id = id;
        this.rank = rank;
        this.first = first;
        this.last = last;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Rank getRank() {
        return rank;
    }

    public void setRank(Rank rank) {
        this.rank = rank;
    }

    public String getFirst() {
        return first;
    }

    public void setFirst(String first) {
        this.first = first;
    }

    public String getLast() {
        return last;
    }

    public void setLast(String last) {
        this.last = last;
    }

    @Override
    public String toString() {
        return "Officer{" +
                "id=" + id +
                ", rank=" + rank +
                ", first='" + first + '\'' +
                ", last='" + last + '\'' +
                '}';
    }
}
