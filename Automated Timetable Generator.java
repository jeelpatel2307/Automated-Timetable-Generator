import random

class Course:
    def __init__(self, name, duration):
        self.name = name
        self.duration = duration

class TimetableGenerator:
    def __init__(self, courses):
        self.courses = courses
        self.timetable = []

    def generate_timetable(self):
        total_duration = sum(course.duration for course in self.courses)
        slots = ["Morning", "Afternoon", "Evening"]
        days = ["Monday", "Tuesday", "Wednesday", "Thursday", "Friday"]

        for day in days:
            day_schedule = {}
            for slot in slots:
                course = random.choice(self.courses)
                self.courses.remove(course)
                day_schedule[slot] = course
            self.timetable.append((day, day_schedule))
        
        return self.timetable

    def display_timetable(self):
        print("Automated Timetable:")
        for day, day_schedule in self.timetable:
            print(day)
            for slot, course in day_schedule.items():
                print(f"- {slot}: {course.name} ({course.duration} hours)")
            print()


def main():
    courses = [Course("Mathematics", 2),
               Course("English", 1),
               Course("Science", 1),
               Course("History", 2),
               Course("Programming", 2)]

    generator = TimetableGenerator(courses)
    timetable = generator.generate_timetable()
    generator.display_timetable()


if __name__ == "__main__":
    main()
